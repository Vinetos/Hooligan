# Hooligan
Just a cool tool that do the transfert between a nodejs server and a fireman application

# Build
***Prerequisites*** : 
- Java 11 (JDK and JRE) and newer  

```sh
# Clone the repo
git clone https://github.com/safexty/Hooligan.git
cd Hooligan

# Build the project
gradlew clean build
```

File will be located in `build/libs/Hooligan-0.0.1.jar`

# Usage
```
# Launch the jar
java -jar ./build/libs/Hooligan-0.0.1.jar <command> [args...]

# Login Example : 
java -jar ./build/libs/Hooligan-0.0.1.jar login username password
```
