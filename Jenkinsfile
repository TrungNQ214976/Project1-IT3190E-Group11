node{
    stage('SCM') {
        git branch: 'NhuDucMinh20214966', credentialsId: 'github-credentials', url: 'https://github.com/TrungNQ214976/Project1-Group11-Service-log-program.git'}
    stage('SonarQube Analysis') {
        def scannerHome = tool 'SonarQube Scanner';withSonarQubeEnv() {sh  "${scannerHome}/bin/sonar-scanner -Dsonar.java.binaries=.  -Dsonar.projectKey=Test -Dsonar.login=squ_c9892daffbb2714637b9e093ecdbcc84648a16a6"}
        }
    }
