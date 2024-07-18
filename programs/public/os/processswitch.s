# TODO: set up exception handler
# TODO: set up mepc to point to the first instruction of the fibonacci function
# TODO: enable and set up interrupts as needed
# TODO: set up data structures for process control blocks
# TODO: execute the fibonacci function until you get an interrupt
    la t1 fibonacci # load start address of the first proccess 
    csrw mepc, t1 #set it to mepc
    la t3 exception_handler # load address of the exception handler
    csrw mtvec, t3
    csrr t4 mstatus 
    li t5 0x00000008 # enable interrupts previous mode is user mode pervius interrupt enable is 0
    or t4 t4 t5
    csrw mstatus t4
    li t4 0x80 
    csrw mie t4 # set the 7th bit of mie to 1 to enable timer interrupts
    li t6 0xffff0008 # load address of the mtime cmp 
    li t5 300 
    sw t5 0(t6) #set 300 as the limit
    mret

exception_handler:
    #TODO: here we store the registers for the current process
    
    csrr t0 , mepc 
    sw
    csrr t1 , mcause
    li t2 , 7 
    beq t1 t2 handle_proc_switch


    handle_proc_switch: 
    #here we load the registers of the second proccess
    li t6 0xffff0000 # reset the timer back to 0 
    li t5 0
    sw t5 0(t6)




    # TODO: save some registers
    # TODO: set up new timer interrupt + implement process switch
    # TODO: return to user mode to continue with next process