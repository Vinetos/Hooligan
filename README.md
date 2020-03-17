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

File will be located in `build/libs/Hooligan-1.0.0.jar`

# Usage
```
# Launch the application
java -jar ./build/libs/Hooligan-1.0.0.jar
```

The first time, the application will generate `config.yml`. Configure it !
