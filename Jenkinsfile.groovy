pipeline{
    agent any
    options{
        timeout(time: 10, unit: 'MINUTES')
    }
    environment{
        PROJECT_NAME = 'myFirstProjectName'
    }
    parameters {
        booleanParam(defaultValue: "true", name: "isTrue",description:"if is true")
    string(defaultValue: "tovi", name: "myFirstName", description: "myName" )
    }
    stages{
        stage('true parameter') {
            when {
                expression {
                    return params.isTrue
                }
            }
            steps{
                echo "my name :${ params.myFirstName}"
            echo "my project name :${env.PROJECT_NAME}"
            }
        }
    }
}