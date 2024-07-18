.section .text
.global _start

_start:
    # Set up exception handler
    la t0, exception_handler        # Load address of exception handler into t0
    csrw mtvec, t0                  # Set mtvec to the exception handler address

    # Set mepc to the user system calls address
    la t1, user_systemcalls         # Load the address of user_systemcalls into t1
    csrw mepc, t1                   # Set mepc to the start of the user system calls

    # Set mstatus to enable user mode
    csrr t2, mstatus                # Read mstatus into t2
    li t3, 0x00001800               # Mask for MPP to set previous privilege mode to user mode (00)
    and t2, t2, t3                  # Clear MPP field in mstatus
    csrw mstatus, t2                # Write updated mstatus back
    mret                            # Return to user mode and start execution at user_systemcalls

exception_handler:

    #here we need to save all the registers that might be used in user mode 
    # Save registers needed for handling the exception
    sw ra 0(x0)
    sw t0 4(x0)
    sw t1 8(x0)
    sw t2 12(x0)
    sw t3 16(x0)
    sw t4 20(x0)
    sw t5 24(x0)
    sw t5 2056(x0)
    csrr t0, mepc     # Save mepc (Program Counter) into t0
    csrr t1, mcause   # Save mcause (Cause of the exception) into t1
    li t2, 8          # Load immediate value 8 into t2 (Environment call exception code)

    beq t1, t2, handle_ecall  # If the cause of exception is ecall, jump to handle_ecall

    # Default exception handler (if needed)
    # Restore registers and return
    mret

handle_ecall:
    # Handle the ecall exception
    addi t0, t0, 4    # Increment mepc by 4 to skip the ecall instruction
    csrw mepc, t0     # Write the incremented value back to mepc

    # Check for specific ecall number
    li t3, 11         # Ecall code for print_character
    beq a7, t3, print_character

    li t3, 4          # Ecall code for print_string
    beq a7, t3, print_string

    # Restore registers and return from exception
    j ret              # Return from machine mode to previous mode

print_character:
    # Print character to display_data memory-mapped register
    li t4, 0xffff001c # Address of display_data register
    sw a0, 0(t4)      # Write character to display_data register

    # Restore registers and return from exception
    j ret              # Return from machine mode to previous mode

print_string:
    # Print null-terminated string to display
    li t4, 0xffff001c # Address of display_data register

print_string_loop:
    lbu t5, 0(a0)     # Load byte from address in a0
    beq t5, x0, end_print_string # If null terminator, end loop
    sw t5, 0(t4)      # Write byte to display_data register
    addi a0, a0, 1    # Increment address in a0
    j print_string_loop

end_print_string:
    # Restore registers and return from exception
    j ret

ret:
    lw ra 0(x0)
    lw t0 4(x0)
    lw t1 8(x0)
    lw t2 12(x0)
    lw t3 16(x0)
    lw t4 20(x0)
    lw t5 24(x0)
    mret