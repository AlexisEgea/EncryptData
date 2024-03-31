#!/bin/bash

function decodeData() {
	local path="$1"
	local data="$2"
    	javac -cp "lib/*" -d bin/ src/*.java
    	java -cp "bin:lib/*" DecodeData $path $data
	cd bin/
	rm *
}

function decodeExecution(){
	project_directory="$1"
	data="$2"
	cd "$project_directory"
	decodeData "$project_directory/Profile.xlsx" "$data"
}

echo "Decoding... In Progress"
echo "_________________________________________________________________________________________________________________________________________________________"
echo "Requirement: Having Java"
echo "Adding bin folder"
mkdir bin/
echo "_________________________________________________________________________________________________________________________________________________________"
echo "Install Open-jdk 19 for this project"
echo
sudo apt install openjdk-19-jdk-headless
echo "_________________________________________________________________________________________________________________________________________________________"

project_directory="${PWD}"
data="Password"

decodeExecution "$project_directory" "$data"

echo "_________________________________________________________________________________________________________________________________________________________"
echo "Decoding $config... DONE"

read -s -p "Press Enter to finish the script..."
