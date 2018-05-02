java -jar --add-modules java.xml.bind rest.jar &

read -p "Run test REST request?"

curl  http://localhost:8080/student/list
