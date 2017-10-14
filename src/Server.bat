::  USER-SPECIFIC VARIABLES, PLEASE SET THESE

::  OUTPUT_DIRECTORY
::  The directory where all your *.class files end up
::  In IntelliJ, the default is ${YOUR_PROJECT_FOLDER}/out/production/${YOUR_PROJECT_NAME}
set OUTPUT_DIRECTORY=C:\Users\Thomas\Dropbox\IdeaProjects\5-Distributed-Systems-RMI\out\production\5-Distributed-Systems-RMI

::  CODEBASE
::  The directory where all source code is stored. (If we ever decide to separate client and server codebases, we need to review this!)
set CODEBASE=C:\Users\Thomas\Dropbox\IdeaProjects\5-Distributed-Systems-RMI\src\

::  POLICY_FILE
::  The full path to the policy file to be used by the application
set POLICY_FILE=C:\Users\Thomas\Dropbox\IdeaProjects\5-Distributed-Systems-RMI\src\RMI\java.policy

::  END OF USER-SPECIFIC VARIABLES, PLEASE DO NOT TOUCH ANYTHING BEYOND THIS LINE

start rmiregistry

set currentDir=%cd%

cd C:\Users\Thomas\Dropbox\IdeaProjects\5-Distributed-Systems-RMI\out\production\5-Distributed-Systems-RMI

java -cp %OUTPUT_DIRECTORY% ^
-Djava.rmi.server.codebase=file:\\%CODEBASE% ^
-Djava.security.policy=%POLICY_FILE% ^
RMI.ServerMain

cd %currentDir%