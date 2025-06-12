@Library("sharedLib") _
pipeline {
    agent any

    environment {
        MT_BRANCH_NAME = 'main'
        TZ = 'Asia/Jerusalem'
    }

    parameters {
        string(name: "BRANCH_NAME", defaultValue: "main", description: "Branch to build")
        string(name: "REPO_URL", defaultValue: "https://github.com/TOVI15/FinalPipeline.git", description: "Git repository URL")
    }

    triggers {
        cron('TZ=Asia/Jerusalem\n30 5 * * 1')     // יום שני 05:30
        cron('TZ=Asia/Jerusalem\n0 14 * * *')     // כל יום 14:00
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    def isMain = (params.BRANCH_NAME == env.MT_BRANCH_NAME)
                    echo "Branch selected: ${params.BRANCH_NAME}"
                    echo "Checking out ${isMain ? 'using Jenkins SCM' : 'manually'}..."

                    if (isMain) {
                        checkout scm
                    } else {
                        git branch: params.BRANCH_NAME, url: params.REPO_URL
                    }
                }
            }
        }

        stage('Compile') {
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
            steps {
                echo "🔨 Starting compilation stage..."
                sh 'mvn compile'
                echo "✅ Compilation stage completed successfully!"
            }
        }

        stage('Run Tests') {
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
            steps {
                echo "🧪 Running test stage..."
                sh 'mvn test'
                echo "✅ Test stage completed successfully!"
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check the logs."
        }
    }
}
