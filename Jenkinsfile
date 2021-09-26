pipeline{
	agent any
	tools{
	maven 'apache-maven-3.8.1'
	}
	stages{
		stage('checkout'){
			steps{
				git 'https://github.com/Nivetha1509/UrbanladderHybrid.git'
			}
		}
		stage('mvn Test'){
			steps{
				bat 'mvn --version'
			}
		}
		stage('Build'){
			steps{
				bat 'mvn clean install'
			}
		}
		stage('Hello'){
			steps{
				echo 'Hello World from Jenkins and Github!'
			}
		}
		 finally{  
               stage('send notification')
                     {
                                mail to:'nivethas120@gmail.com',
                                body :"something went wrong ${env.BUILD_URL}",
                                subject:"failed ${currentBuild.fullDisplayName}"
                      }
                      }
		
	}
}
