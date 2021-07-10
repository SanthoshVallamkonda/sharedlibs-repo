def call(nexusRepo){
  def pom = readMavenPom file: 'pom.xml'
  def artifacdId = pom.artifactId
  def version = pom.version
  def package = pom.packaging
  def groupdId = pom.groupId
  def repo = nexusRepo//pom.version.endsWith('SNAPSHOT') ? "my-app-snapshot" : "my-app-release"
  nexusArtifactUploader artifacts: [[artifactId: artifacdId, classifier: '', file: "target/${artifacdId}-${version}.${package}", type: package]], 
  credentialsId: 'nexus3', 
  groupId: groupdId, 
  nexusUrl: '172.31.44.155:8081', 
  nexusVersion: 'nexus3', 
  protocol: 'http', 
  repository: repo, 
  version: version
}
