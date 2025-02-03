
# import os

# Directory: List of the folders you want to create
file_names = [
    'jv_ch02_01_class_in_Java',
    'jv_ch02_02_reference_assignment',
    'jv_ch02_03_1_methods_return',
    'jv_ch02_03_2_methods_parameters',
    'jv_ch02_04_constructor_new',
    'jv_ch02_05_garbage_finalize',
    'jv_ch02_06_this',
    'jv_ch02_07_1_Array_1D',
    'jv_ch02_07_2_MultiD_irregular',
    'jv_ch02_07_3_Array_Advanced',
    'jv_ch02_07_4_Stack_Queue',
    'jv_ch02_08_for_each',
    'jv_ch02_09_1_strings',
    'jv_ch02_09_2_strAdv_imutble_cmd',
    'jv_ch02_10_bitwise_operators',
    'jv_ch02_11_ternary_operator'
]

# Parent Directory path
# parent_dir = "D:/Pycharm projects/GeeksForGeeks/Authors"

# Path
# path = os.path.join(parent_dir, directory)
for i in range (0, len(file_names)):
    # path = "./"+directories[i]
    # Create the files
    try:
        with open(f"{file_names[i]}.java", "w") as f:     # creates an empty 'java' file
            f.write("\n/* -=-=-=-=-=-=-=-=-=-=-=      chapter name      -=-=-=-=-=-=-=-=-=-=-= */\n")
        print(f"{file_names[i]}.py is created sucuessfully")
    except:
        print("files '%s' can not be created" % file_names[i])

# run windows cmd/terminal inside the working directory

# python file_creator.py


