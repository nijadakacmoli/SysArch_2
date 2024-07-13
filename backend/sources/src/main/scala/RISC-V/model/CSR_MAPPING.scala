package RISCV.model


import chisel3._

object CSR_MAPPING extends ChiselEnum {

    // val FFLAGS = Value(0x001.U)
    // val FRM = Value(0x002.U)
    // val FCSR = Value(0x003.U)

    // val SSTATUS = Value(0x100.U)
    // val SIE = Value(0x104.U)
    // val STVEC = Value(0x105.U)
    // val SCOUNTEREN = Value(0x106.U)
    // val SENVCFG = Value(0x10A.U)
    // val SSTATEEN0 = Value(0x10C.U)
    // val SSTATEEN1 = Value(0x10D.U)
    // val SSTATEEN2 = Value(0x10E.U)
    // val SSTATEEN3 = Value(0x10F.U)
    // val scountinhibit = Value(0x120.U)
    // val SSCRATCH = Value(0x140.U)
    // val SEPC = Value(0x141.U)
    // val SCAUSE = Value(0x142.U)
    // val STVAL = Value(0x143.U)
    // val SIP = Value(0x144.U)
    // val SATP = Value(0x180.U)

    // val VSSTATUS = Value(0x200.U)
    // val VSIE = Value(0x204.U)
    // val VSTVEC = Value(0x205.U)
    // val VSSCRATCH = Value(0x240.U)
    // val VSEPC = Value(0x241.U)
    // val VSCAUSE = Value(0x242.U)
    // val VSTVAL = Value(0x243.U)
    // val VSIP = Value(0x244.U)
    // val VSATP = Value(0x280.U)

    val MSTATUS = Value(0x300.U)
    val MISA = Value(0x301.U)
    val MEDELEG = Value(0x302.U)
    val MIDELEG = Value(0x303.U)
    val MIE = Value(0x304.U)
    val MTVEC = Value(0x305.U)
    val MCOUNTEREN = Value(0x306.U)
    // val MENVCFG = Value(0x30A.U)
    // val MSTATEEN0 = Value(0x30C.U)
    // val MSTATEEN1 = Value(0x30D.U)
    // val MSTATEEN2 = Value(0x30E.U)
    // val MSTATEEN3 = Value(0x30F.U)
    val MSTATUSH = Value(0x310.U)
    val MEDELEGH = Value(0x312.U)
    // val MENVCFGH = Value(0x31A.U)
    // val MSTATEEN0H = Value(0x31C.U)
    // val MSTATEEN1H = Value(0x31D.U)
    // val MSTATEEN2H = Value(0x31E.U)
    // val MSTATEEN3H = Value(0x31F.U)
    val MCOUNTINHIBIT = Value(0x320.U)
    // val MHPMEVENT3 = Value(0x323.U)
    // val MHPMEVENT4 = Value(0x324.U)
    // val MHPMEVENT5 = Value(0x325.U)
    // val MHPMEVENT6 = Value(0x326.U)
    // val MHPMEVENT7 = Value(0x327.U)
    // val MHPMEVENT8 = Value(0x328.U)
    // val MHPMEVENT9 = Value(0x329.U)
    // val MHPMEVENT10 = Value(0x32A.U)
    // val MHPMEVENT11 = Value(0x32B.U)
    // val MHPMEVENT12 = Value(0x32C.U)
    // val MHPMEVENT13 = Value(0x32D.U)
    // val MHPMEVENT14 = Value(0x32E.U)
    // val MHPMEVENT15 = Value(0x32F.U)
    // val MHPMEVENT16 = Value(0x330.U)
    // val MHPMEVENT17 = Value(0x331.U)
    // val MHPMEVENT18 = Value(0x332.U)
    // val MHPMEVENT19 = Value(0x333.U)
    // val MHPMEVENT20 = Value(0x334.U)
    // val MHPMEVENT21 = Value(0x335.U)
    // val MHPMEVENT22 = Value(0x336.U)
    // val MHPMEVENT23 = Value(0x337.U)
    // val MHPMEVENT24 = Value(0x338.U)
    // val MHPMEVENT25 = Value(0x339.U)
    // val MHPMEVENT26 = Value(0x33A.U)
    // val MHPMEVENT27 = Value(0x33B.U)
    // val MHPMEVENT28 = Value(0x33C.U)
    // val MHPMEVENT29 = Value(0x33D.U)
    // val MHPMEVENT30 = Value(0x33E.U)
    // val MHPMEVENT31 = Value(0x33F.U)
    val MSCRATCH = Value(0x340.U)
    val MEPC = Value(0x341.U)
    val MCAUSE = Value(0x342.U)
    val MTVAL = Value(0x343.U)
    val MIP = Value(0x344.U)
    val MTINST = Value(0x34A.U)
    // val MTVAL2 = Value(0x34B.U)
    // val PMPCFG0 = Value(0x3A0.U)
    // val PMPCFG1 = Value(0x3A1.U)
    // val PMPCFG2 = Value(0x3A2.U)
    // val PMPCFG3 = Value(0x3A3.U)
    // val PMPCFG4 = Value(0x3A4.U)
    // val PMPCFG5 = Value(0x3A5.U)
    // val PMPCFG6 = Value(0x3A6.U)
    // val PMPCFG7 = Value(0x3A7.U)
    // val PMPCFG8 = Value(0x3A8.U)
    // val PMPCFG9 = Value(0x3A9.U)
    // val PMPCFG10 = Value(0x3AA.U)
    // val PMPCFG11 = Value(0x3AB.U)
    // val PMPCFG12 = Value(0x3AC.U)
    // val PMPCFG13 = Value(0x3AD.U)
    // val PMPCFG14 = Value(0x3AE.U)
    // val PMPCFG15 = Value(0x3AF.U)
    // val PMPADDR0 = Value(0x3B0.U)
    // val PMPADDR1 = Value(0x3B1.U)
    // val PMPADDR2 = Value(0x3B2.U)
    // val PMPADDR3 = Value(0x3B3.U)
    // val PMPADDR4 = Value(0x3B4.U)
    // val PMPADDR5 = Value(0x3B5.U)
    // val PMPADDR6 = Value(0x3B6.U)
    // val PMPADDR7 = Value(0x3B7.U)
    // val PMPADDR8 = Value(0x3B8.U)
    // val PMPADDR9 = Value(0x3B9.U)
    // val PMPADDR10 = Value(0x3BA.U)
    // val PMPADDR11 = Value(0x3BB.U)
    // val PMPADDR12 = Value(0x3BC.U)
    // val PMPADDR13 = Value(0x3BD.U)
    // val PMPADDR14 = Value(0x3BE.U)
    // val PMPADDR15 = Value(0x3BF.U)
    // val PMPADDR16 = Value(0x3C0.U)
    // val PMPADDR17 = Value(0x3C1.U)
    // val PMPADDR18 = Value(0x3C2.U)
    // val PMPADDR19 = Value(0x3C3.U)
    // val PMPADDR20 = Value(0x3C4.U)
    // val PMPADDR21 = Value(0x3C5.U)
    // val PMPADDR22 = Value(0x3C6.U)
    // val PMPADDR23 = Value(0x3C7.U)
    // val PMPADDR24 = Value(0x3C8.U)
    // val PMPADDR25 = Value(0x3C9.U)
    // val PMPADDR26 = Value(0x3CA.U)
    // val PMPADDR27 = Value(0x3CB.U)
    // val PMPADDR28 = Value(0x3CC.U)
    // val PMPADDR29 = Value(0x3CD.U)
    // val PMPADDR30 = Value(0x3CE.U)
    // val PMPADDR31 = Value(0x3CF.U)
    // val PMPADDR32 = Value(0x3D0.U)
    // val PMPADDR33 = Value(0x3D1.U)
    // val PMPADDR34 = Value(0x3D2.U)
    // val PMPADDR35 = Value(0x3D3.U)
    // val PMPADDR36 = Value(0x3D4.U)
    // val PMPADDR37 = Value(0x3D5.U)
    // val PMPADDR38 = Value(0x3D6.U)
    // val PMPADDR39 = Value(0x3D7.U)
    // val PMPADDR40 = Value(0x3D8.U)
    // val PMPADDR41 = Value(0x3D9.U)
    // val PMPADDR42 = Value(0x3DA.U)
    // val PMPADDR43 = Value(0x3DB.U)
    // val PMPADDR44 = Value(0x3DC.U)
    // val PMPADDR45 = Value(0x3DD.U)
    // val PMPADDR46 = Value(0x3DE.U)
    // val PMPADDR47 = Value(0x3DF.U)
    // val PMPADDR48 = Value(0x3E0.U)
    // val PMPADDR49 = Value(0x3E1.U)
    // val PMPADDR50 = Value(0x3E2.U)
    // val PMPADDR51 = Value(0x3E3.U)
    // val PMPADDR52 = Value(0x3E4.U)
    // val PMPADDR53 = Value(0x3E5.U)
    // val PMPADDR54 = Value(0x3E6.U)
    // val PMPADDR55 = Value(0x3E7.U)
    // val PMPADDR56 = Value(0x3E8.U)
    // val PMPADDR57 = Value(0x3E9.U)
    // val PMPADDR58 = Value(0x3EA.U)
    // val PMPADDR59 = Value(0x3EB.U)
    // val PMPADDR60 = Value(0x3EC.U)
    // val PMPADDR61 = Value(0x3ED.U)
    // val PMPADDR62 = Value(0x3EE.U)
    // val PMPADDR63 = Value(0x3EF.U)

    // val SCONTEXT = Value(0x5A8.U)

    // val HSSTATUS = Value(0x600.U)
    // val HEDELEG = Value(0x602.U)
    // val HIDELEG = Value(0x603.U)
    // val HIE = Value(0x604.U)
    // val HTIMEDELTA = Value(0x605.U)
    // val HCOUNTEREN = Value(0x606.U)
    // val HGEIE = Value(0x607.U)
    // val HENVCFG = Value(0x60A.U)
    // val HSTATEEN0 = Value(0x60C.U)
    // val HSTATEEN1 = Value(0x60D.U)
    // val HSTATEEN2 = Value(0x60E.U)
    // val HSTATEEN3 = Value(0x60F.U)
    // val HEDELEGH = Value(0x612.U)
    // val HTIMEDELTAH = Value(0x615.U)
    // val HENVCFGH = Value(0x61A.U)
    // val HSTATEEN0H = Value(0x61C.U)
    // val HSTATEEN1H = Value(0x61D.U)
    
    // val HSTATEEN2H = Value(0x61E.U)
    // val HSTATEEN3H = Value(0x61F.U)
    
    // val HTVAL = Value(0x643.U)
    // val HIP = Value(0x644.U)
    // val HVIP = Value(0x645.U)
    // val HTINST = Value(0x64A.U)
    // val HGATP = Value(0x680.U)
    // val HCONTEXT = Value(0x6A8.U)

    // val MHPMEVENT3H = Value(0x723.U)
    // val MHPMEVENT4H = Value(0x724.U)
    // val MHPMEVENT5H = Value(0x725.U)
    // val MHPMEVENT6H = Value(0x726.U)
    // val MHPMEVENT7H = Value(0x727.U)
    // val MHPMEVENT8H = Value(0x728.U)
    // val MHPMEVENT9H = Value(0x729.U)
    // val MHPMEVENT10H = Value(0x72A.U)
    // val MHPMEVENT11H = Value(0x72B.U)
    // val MHPMEVENT12H = Value(0x72C.U)
    // val MHPMEVENT13H = Value(0x72D.U)
    // val MHPMEVENT14H = Value(0x72E.U)
    // val MHPMEVENT15H = Value(0x72F.U)
    // val MHPMEVENT16H = Value(0x730.U)
    // val MHPMEVENT17H = Value(0x731.U)
    // val MHPMEVENT18H = Value(0x732.U)
    // val MHPMEVENT19H = Value(0x733.U)
    // val MHPMEVENT20H = Value(0x734.U)
    // val MHPMEVENT21H = Value(0x735.U)
    // val MHPMEVENT22H = Value(0x736.U)
    // val MHPMEVENT23H = Value(0x737.U)
    // val MHPMEVENT24H = Value(0x738.U)
    // val MHPMEVENT25H = Value(0x739.U)
    // val MHPMEVENT26H = Value(0x73A.U)
    // val MHPMEVENT27H = Value(0x73B.U)
    // val MHPMEVENT28H = Value(0x73C.U)
    // val MHPMEVENT29H = Value(0x73D.U)
    // val MHPMEVENT30H = Value(0x73E.U)
    // val MHPMEVENT31H = Value(0x73F.U)
    // val MNSCRATCH = Value(0x740.U)
    // val MNEPC = Value(0x741.U)
    // val MNCAUSE = Value(0x742.U)
    // val MNSTATUS = Value(0x743.U)
    // val MSECCFG = Value(0x747.U)
    // val MSECCFGH = Value(0x757.U)
    // val TSELECT = Value(0x7A0.U)
    // val TDATA1 = Value(0x7A1.U)
    // val TDATA2 = Value(0x7A2.U)
    // val TDATA3 = Value(0x7A3.U)
    // val MCONTEXT = Value(0x7A8.U)
    // val DCSR = Value(0x7B0.U)
    // val DPC = Value(0x7B1.U)
    // val DSCRATCH0 = Value(0x7B2.U)
    // val DSCRATCH1 = Value(0x7B3.U)

    val MCYCLE = Value(0xB00.U)
    val MINSTRET = Value(0xB02.U)
    // val MHPMCOUNTER3 = Value(0xB03.U)
    // val MHPMCOUNTER4 = Value(0xB04.U)
    // val MHPMCOUNTER5 = Value(0xB05.U)
    // val MHPMCOUNTER6 = Value(0xB06.U)
    // val MHPMCOUNTER7 = Value(0xB07.U)
    // val MHPMCOUNTER8 = Value(0xB08.U)
    // val MHPMCOUNTER9 = Value(0xB09.U)
    // val MHPMCOUNTER10 = Value(0xB0A.U)
    // val MHPMCOUNTER11 = Value(0xB0B.U)
    // val MHPMCOUNTER12 = Value(0xB0C.U)
    // val MHPMCOUNTER13 = Value(0xB0D.U)
    // val MHPMCOUNTER14 = Value(0xB0E.U)
    // val MHPMCOUNTER15 = Value(0xB0F.U)
    // val MHPMCOUNTER16 = Value(0xB10.U)
    // val MHPMCOUNTER17 = Value(0xB11.U)
    // val MHPMCOUNTER18 = Value(0xB12.U)
    // val MHPMCOUNTER19 = Value(0xB13.U)
    // val MHPMCOUNTER20 = Value(0xB14.U)
    // val MHPMCOUNTER21 = Value(0xB15.U)
    // val MHPMCOUNTER22 = Value(0xB16.U)
    // val MHPMCOUNTER23 = Value(0xB17.U)
    // val MHPMCOUNTER24 = Value(0xB18.U)
    // val MHPMCOUNTER25 = Value(0xB19.U)
    // val MHPMCOUNTER26 = Value(0xB1A.U)
    // val MHPMCOUNTER27 = Value(0xB1B.U)
    // val MHPMCOUNTER28 = Value(0xB1C.U)
    // val MHPMCOUNTER29 = Value(0xB1D.U)
    // val MHPMCOUNTER30 = Value(0xB1E.U)
    // val MHPMCOUNTER31 = Value(0xB1F.U)
    val MCYCLEH = Value(0xB80.U)
    val MINSTRETH = Value(0xB82.U)
    // val MHPMCOUNTER3H = Value(0xB83.U)
    // val MHPMCOUNTER4H = Value(0xB84.U)
    // val MHPMCOUNTER5H = Value(0xB85.U)
    // val MHPMCOUNTER6H = Value(0xB86.U)
    // val MHPMCOUNTER7H = Value(0xB87.U)
    // val MHPMCOUNTER8H = Value(0xB88.U)
    // val MHPMCOUNTER9H = Value(0xB89.U)
    // val MHPMCOUNTER10H = Value(0xB8A.U)
    // val MHPMCOUNTER11H = Value(0xB8B.U)
    // val MHPMCOUNTER12H = Value(0xB8C.U)
    // val MHPMCOUNTER13H = Value(0xB8D.U)
    // val MHPMCOUNTER14H = Value(0xB8E.U)
    // val MHPMCOUNTER15H = Value(0xB8F.U)
    // val MHPMCOUNTER16H = Value(0xB90.U)
    // val MHPMCOUNTER17H = Value(0xB91.U)
    // val MHPMCOUNTER18H = Value(0xB92.U)
    // val MHPMCOUNTER19H = Value(0xB93.U)
    // val MHPMCOUNTER20H = Value(0xB94.U)
    // val MHPMCOUNTER21H = Value(0xB95.U)
    // val MHPMCOUNTER22H = Value(0xB96.U)
    // val MHPMCOUNTER23H = Value(0xB97.U)
    // val MHPMCOUNTER24H = Value(0xB98.U)
    // val MHPMCOUNTER25H = Value(0xB99.U)
    // val MHPMCOUNTER26H = Value(0xB9A.U)
    // val MHPMCOUNTER27H = Value(0xB9B.U)
    // val MHPMCOUNTER28H = Value(0xB9C.U)
    // val MHPMCOUNTER29H = Value(0xB9D.U)
    // val MHPMCOUNTER30H = Value(0xB9E.U)
    // val MHPMCOUNTER31H = Value(0xB9F.U)
    val CYCLE = Value(0xC00.U)
    val TIME = Value(0xC01.U)
    val INSTRET = Value(0xC02.U)
    // val HPMCOUNTER3 = Value(0xC03.U)
    // val HPMCOUNTER4 = Value(0xC04.U)
    // val HPMCOUNTER5 = Value(0xC05.U)
    // val HPMCOUNTER6 = Value(0xC06.U)
    // val HPMCOUNTER7 = Value(0xC07.U)
    // val HPMCOUNTER8 = Value(0xC08.U)
    // val HPMCOUNTER9 = Value(0xC09.U)
    // val HPMCOUNTER10 = Value(0xC0A.U)
    // val HPMCOUNTER11 = Value(0xC0B.U)
    // val HPMCOUNTER12 = Value(0xC0C.U)
    // val HPMCOUNTER13 = Value(0xC0D.U)
    // val HPMCOUNTER14 = Value(0xC0E.U)
    // val HPMCOUNTER15 = Value(0xC0F.U)
    // val HPMCOUNTER16 = Value(0xC10.U)
    // val HPMCOUNTER17 = Value(0xC11.U)
    // val HPMCOUNTER18 = Value(0xC12.U)
    // val HPMCOUNTER19 = Value(0xC13.U)
    // val HPMCOUNTER20 = Value(0xC14.U)
    // val HPMCOUNTER21 = Value(0xC15.U)
    // val HPMCOUNTER22 = Value(0xC16.U)
    // val HPMCOUNTER23 = Value(0xC17.U)
    // val HPMCOUNTER24 = Value(0xC18.U)
    // val HPMCOUNTER25 = Value(0xC19.U)
    // val HPMCOUNTER26 = Value(0xC1A.U)
    // val HPMCOUNTER27 = Value(0xC1B.U)
    // val HPMCOUNTER28 = Value(0xC1C.U)
    // val HPMCOUNTER29 = Value(0xC1D.U)
    // val HPMCOUNTER30 = Value(0xC1E.U)
    // val HPMCOUNTER31 = Value(0xC1F.U)
    val CYCLEH = Value(0xC80.U)
    val TIMEH = Value(0xC81.U)
    val INSTRETH = Value(0xC82.U)
    // val HPMCOUNTER3H = Value(0xC83.U)
    // val HPMCOUNTER4H = Value(0xC84.U)
    // val HPMCOUNTER5H = Value(0xC85.U)
    // val HPMCOUNTER6H = Value(0xC86.U)
    // val HPMCOUNTER7H = Value(0xC87.U)
    // val HPMCOUNTER8H = Value(0xC88.U)
    // val HPMCOUNTER9H = Value(0xC89.U)
    // val HPMCOUNTER10H = Value(0xC8A.U)
    // val HPMCOUNTER11H = Value(0xC8B.U)
    // val HPMCOUNTER12H = Value(0xC8C.U)
    // val HPMCOUNTER13H = Value(0xC8D.U)
    // val HPMCOUNTER14H = Value(0xC8E.U)
    // val HPMCOUNTER15H = Value(0xC8F.U)
    // val HPMCOUNTER16H = Value(0xC90.U)
    // val HPMCOUNTER17H = Value(0xC91.U)
    // val HPMCOUNTER18H = Value(0xC92.U)
    // val HPMCOUNTER19H = Value(0xC93.U)
    // val HPMCOUNTER20H = Value(0xC94.U)
    // val HPMCOUNTER21H = Value(0xC95.U)
    // val HPMCOUNTER22H = Value(0xC96.U)
    // val HPMCOUNTER23H = Value(0xC97.U)
    // val HPMCOUNTER24H = Value(0xC98.U)
    // val HPMCOUNTER25H = Value(0xC99.U)
    // val HPMCOUNTER26H = Value(0xC9A.U)
    // val HPMCOUNTER27H = Value(0xC9B.U)
    // val HPMCOUNTER28H = Value(0xC9C.U)
    // val HPMCOUNTER29H = Value(0xC9D.U)
    // val HPMCOUNTER30H = Value(0xC9E.U)
    // val HPMCOUNTER31H = Value(0xC9F.U)

    // val SCOUNTOVF = Value(0xDA0.U)

    // val hgeip = Value(0xE12.U)
    
    val MVENDORID = Value(0xF11.U)
    val MARCHID = Value(0xF12.U)
    val MIMPID = Value(0xF13.U)
    val MHARTID = Value(0xF14.U)
    val MCONFIGPTR = Value(0xF15.U)

    val UNKNOWN = Value(0xFFF.U)

    def apply(i: UInt): CSR_MAPPING.Type = {
        return Mux(CSR_MAPPING.safe(i)._2, CSR_MAPPING.safe(i)._1, CSR_MAPPING.UNKNOWN)
    }
}