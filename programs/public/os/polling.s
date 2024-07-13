_start:
    # Main loop
loop:
    # Wait for keyboard input
    li t1, 0xffff0010
keyboard_wait_loop:
    lw t2, 0(t1)
    beqz t2, keyboard_wait_loop  # If keyboard_ready is 0, loop

    # Read keyboard input
    li t1, 0xffff0014
    lw a0, 0(t1)  # Load the ASCII value of the pressed key into a0

    # Wait for display to be ready
    li t1, 0xffff0018
display_wait_loop:
    lw t2, 0(t1)
    beqz t2, display_wait_loop  # If display_ready is 0, loop

    # Print keyboard input to display
    li t1, 0xffff001c
    sw a0, 0(t1)  # Write the ASCII value to display_data

    # Start again
    j loop