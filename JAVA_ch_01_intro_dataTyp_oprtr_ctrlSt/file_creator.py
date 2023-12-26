
# import os

# Directory: List of the folders you want to create
file_names = [
    "jv_ch01_01_1_intro_cnvntion",
    "jv_ch01_01_2_first_run",
    "jv_ch01_01_3_libs_keywrds",
    "jv_ch01_01_4_operators",
    "jv_ch01_01_5_prantsis_space",
    "jv_ch01_01_6_escape_Seq",
    "jv_ch01_02_1_if_for_ctrl_logic",
    "jv_ch01_02_2_if_elif_switch",
    "jv_ch01_02_3_loop_advanced",
    "jv_ch01_02_4_break_continue",
    "jv_ch01_03_1_prmitv_type",
    "jv_ch01_03_2_litrl_hex_bin_oct",
    "jv_ch01_03_3_strings",
    "jv_ch01_03_4_typeCast_convrtn",
    "jv_ch01_04_1_init_dynmicInit",
    "jv_ch01_04_2_scope_VarLife",
    "jv_ch01_05_IO_basic"
]

# Parent Directory path
# parent_dir = "D:/Pycharm projects/GeeksForGeeks/Authors"

# Path
# path = os.path.join(parent_dir, directory)
for i in range (0, len(file_names)):
    # path = "./"+directories[i]
    # Create the files
    try:
        print(f"{file_names[i]} is created sucuessfully")
        with open(f"{file_names[i]}.java", "w") as f:     # creates an empty 'java' file
            f.write("\n/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= */\n")
        print(f"{file_names[i]}.py is created sucuessfully")
    except:
        print("files '%s' can not be created" % file_names[i])

# run windows cmd/terminal inside the working directory

# python file_creator.py

