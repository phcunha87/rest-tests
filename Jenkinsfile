pipeline {
    agent any
        stage ('API Tests'){
            steps {
                dir('api-test'){
                    git 'https://github.com/phcunha87/rest-tests.git'
                    bat 'mvn test'
                }
                
            }
        }
        stage ('Funcional Tests'){
            steps {
                dir('funcional-test'){
                    git 'https://github.com/phcunha87/FuncionalTeste.git'
                    bat 'mvn test'

                }
                
            }
        }
            
	}
    
	
