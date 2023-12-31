# ExercicioAltice-MR

This project was made in response of the exercise made by Altice Labs. The project has two parts, a backend handling the
 server side and the frontend handling a web page to use together with the backend.

# Backend component

The backend component is constituted by an API that receives a number as a parameter and returns
the result the value in the labseq sequence. The labseq is defined as follows:
(The "n" value is the number received as a parameter)

n=0 => l(0) = 0

n=1 => l(1) = 1

n=2 => l(2) = 0

n=3 => l(3) = 1

n>3 => l(n) = l(n-4) + l(n-3)

The parameter must be greater or equal to 0 and lower than 99999. This limit was done since the cache has memory limit.

This project uses Quarkus, a Kubernetes-native Java framework tailored for GraalVM and HotSpot, crafted from best-of-breed 
Java libraries and standards.

## API documentation

The API documentation is in the `backend\api_documentation.yaml` file in the root directory of the project.

## Running the backend application

To run the application in dev mode, you must install quarkus following this:

For Linux, macOS, and Windows (using WSL or bash compatible shell like Cygwin or MinGW)
```shell script
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
````
For Windows using Powershell
```shell script
iex "& { $(iwr https://ps.jbang.dev) } trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/"
iex "& { $(iwr https://ps.jbang.dev) } app install --fresh --force quarkus@quarkusio"
````
If it's your first time to install, you'll need to restart your shell.
Or, you can also install the CLI with SDKMAN!
```shell script
sdk install quarkus
````
For more options, such as Homebrew or Chocolatey, see the Quarkus CLI guide (https://quarkus.io/guides/cli-tooling).

(All this installation information was obtained in https://quarkus.io/get-started/)

After the installation, run the following command on the console using the `backend` as the directory. 
```shell script
quarkus run
````

The server will be hosted on the localhost using port 8080.(It can be accessed by using 127.0.0.1:8080 or localhost:8080)

### Running the tests

To run the tests you must have the application in dev or test mode.

You can access dev mode by using the following command:
```shell script
quarkus dev
```

You can access test mode by using the following command:
```shell script
quarkus test
```

# Frontend component

The frontend component is constituted with only one webpage with an input and a button that allows the client to get
the result of a number in the labseq sequence.

This component uses Angular.js, HTML, TypeScript and CSS.

## Running the frontend application

In order to be able to properly use the web page, the backend application must be turned on.

To run this application you must follow these steps:

1) Install Node.js, you can find the download file on their website https://nodejs.org/en/download/current.

2) Install the Angular by opening a cmd and writing the following command:
```shell script
npm install -g @angular/cli
```
3) Initiate the application by running the following command on the `frontend` directory:
```shell script
ng serve  
```

More information about how to setup Angular.js project in the following website https://radixweb.com/blog/how-to-install-angular-on-windows#Run.

