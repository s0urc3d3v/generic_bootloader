section .text
global _start

_start:
	mov eax, 5
	int 0x80
