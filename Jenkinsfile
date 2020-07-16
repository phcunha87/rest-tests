pipeline {
    agent any
    stages{
        stage ('API TESTS') {
           steps {
                git 'https://github.com/phcunha87/rest-tests.git'
                bat 'mvn test'
            }
        }
        stage ('TESTES FUNCIONAIS') {
            steps {
                git credentialsId: 'Git', url: 'https://github.com/phcunha87/testes-funcionais-dcoker.git'
                bat 'mvn test'
            }
        }
        stage{
            always {
                allure includeProperties: false, jdk: '', results: [[path: 'target/surefire-reports']]
            }

        }
                
    }
    
}       
    
	


