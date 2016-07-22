This directory is meant to contain any system_init code that is necessary to start the greater software herein and hence
may need to contain some assembly.  Use this directory accordingly the outline files are available but are not setup for your
configuration.  Base.* should be filled out with the proper extension and used to start cpu specific config and then start
sys_start.asm with more general assembly the greater program will handle execution after sys_start.asm has run