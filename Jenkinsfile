@Library("sharedLib") _
pipeline{
    agent any
    options{
        timeout(time: 5, unit: 'MINUTES')
    }
    environment{
        MT_BRANCH_NAME = 'main'
    }
    parameters {
        string(defaultValue: "main", name: "BRANCH_NAME", description: "name of this branch")
        string(defaultValue: "https://github.com/TOVI15/FinalPipeline.git", name: "REPO_URL", description: "path url repository" )
    }
    triggers {
        cron('TZ=Asia/Jerusalem\n30 5 * * 1\n0 14 * * *')
    }
    stages {
        stage('checkout code') {
            when {
                expression {
                   return params.BRANCH_NAME == env.MT_BRANCH_NAME
                }
            }
            steps{
                echo "checking out using Jenkins SCM for main branch"
                checkout scm
            }
        }
        stage('Checkout code - Manual git') {
            when {
                expression {
                   return params.BRANCH_NAME != env.MT_BRANCH_NAME
                }
            }
            steps{
                echo "checking out manually from branch: ${params.BRANCH_NAME}"
                git branch: "${params.BRANCH_NAME}", url: "${params.REPO_URL}"
            }
        }
        stage('Compile') {
            steps {
                echo "Starting compilation stage"
                sh 'mvn compile'
                echo 'Compilation stage completed successfully'
            }
        }
        stage('Run Tests') {
            steps {
                echo "Running test stage..."
                sh 'mvn test'
                echo 'Test stage completes successfully'
            }
        }
    }
    post {
        success {
            echo '✅ pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed. Please check the logs.'
        }
    }
}