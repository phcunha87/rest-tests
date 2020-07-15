pipeline {
    agent any
    stages{
        stage ('API TESTS') {
           steps {
                git 'https://github.com/phcunha87/rest-tests.git'
                bat 'mvn test'
            }

        }            
	
    } 
}       
    
	


