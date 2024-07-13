package models

import play.api.libs.json._
import models._

case class StateUpdate(
    index: Int,
    pc: ValueUpdate[BigInt],
    register_updates: Map[Int, ValueUpdate[BigInt]],
    csr_updates: Map[BigInt, ValueUpdate[BigInt]],
    memory_updates: Map[BigInt, ValueUpdate[BigInt]],
    display_output: ValueUpdate[String]
) {
    def getPCValue() = {
        pc.newValue
    }

    def getRegisterValue(address: Int) = {
        if (register_updates.keySet.contains(address)) {
            Option(register_updates(address).newValue)
        } else {
            Option.empty
        }
    }

    def getCSRValue(address: BigInt) = {
        if (csr_updates.keySet.contains(address)) {
            Option(csr_updates(address).newValue)
        } else {
            Option.empty
        }
    }

    def getMemoryValue(address: BigInt) = {
        if (memory_updates.keySet.contains(address)) {
            Option(memory_updates(address).newValue)
        } else {
            Option.empty
        }
    }

    def merge(update: StateUpdate): StateUpdate = {
        val index = update.index
        val new_pc = update.pc
        val new_register_updates = register_updates.filter(x => !update.register_updates.contains(x._1)).toMap ++ update.register_updates
        val new_csr_updates = csr_updates.filter(x => !update.csr_updates.contains(x._1)).toMap ++ update.csr_updates
        val new_memory_updates = memory_updates.filter(x => !update.memory_updates.contains(x._1)).toMap ++ update.memory_updates
        val new_display_output = update.display_output
        new StateUpdate(index, new_pc, new_register_updates, new_csr_updates, new_memory_updates, new_display_output)
    }
}

object StateUpdate {
    implicit val reads : Reads[StateUpdate] = new Reads[StateUpdate] {
        def reads(json: JsValue): JsResult[StateUpdate] = {
            val index = (json \ "index").as[Int]
            val pc = (json \ "pc").as[ValueUpdate[BigInt]]
            val register_updates = (json \ "register_updates").as[Map[Int, ValueUpdate[BigInt]]]
            val csr_updates = (json \ "csr_updates").as[Map[Long, ValueUpdate[BigInt]]].map(x => BigInt(x._1) -> x._2)
            val memory_updates = (json \ "memory_updates").as[Map[Long, ValueUpdate[BigInt]]].map(x => BigInt(x._1) -> x._2)
            val display_output = (json \ "display_output").as[ValueUpdate[String]]
            JsSuccess(new StateUpdate(index, pc, register_updates, csr_updates, memory_updates, display_output))
        }
    }

    implicit val writes : Writes[StateUpdate] = new Writes[StateUpdate] {
        def writes(state_update: StateUpdate): JsValue = {
            Json.obj(
                "index" -> state_update.index,
                "pc" -> Json.toJson(state_update.pc),
                "register_updates" -> Json.toJson(state_update.register_updates),
                "csr_updates" -> Json.toJson(state_update.csr_updates.map(x => x._1.longValue -> x._2)),
                "memory_updates" -> Json.toJson(state_update.memory_updates.map(x => x._1.longValue -> x._2)),
                "display_output" -> Json.toJson(state_update.display_output)
            )
        }
    }
}