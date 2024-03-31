#!/bin/bash

function encodeData() {
	local path="$1"
	local data="$2"
    	javac -cp "lib/*" -d bin/ src/*.java
    	java -cp "bin:lib/*" EncodeData $path $data
	cd bin/
	rm *
}

function encodeExecution(){
	project_directory="$1"
	data="$2"
	cd "$project_directory"
	encodeData "$project_directory/Profile.xlsx" "$data"
}

echo "Encoding... In Progress"
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

encodeExecution "$project_directory" "$data"

echo "_________________________________________________________________________________________________________________________________________________________"
echo "Encoding $config... DONE"

read -s -p "Press Enter to finish the script..."
