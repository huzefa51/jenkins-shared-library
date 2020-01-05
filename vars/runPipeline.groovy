#!/usr/bin/env groovy

def call() {
  echo "Hello huz"
  pipeline {
   agent any
   stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven') {
                    echo "in compile"
                    sh 'mvn clean compile'
                }
            }
        }
        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven') {
                    sh 'mvn test'
                }
            }
        }
        stage ('Install Stage') {
            steps {
                withMaven(maven : 'maven') {
                    sh 'mvn install'
                }
            }
        }
    }
}
}
