
## Apache ZooKeeper 3.5.6 Example


### What is Apache ZooKeeper?

	Apache ZooKeeper is a key-value store.


### Apache ZooKeeper Examples and Guide

	https://zookeeper.apache.org/doc/current/index.html


## Apache ZooKeeper Download, Installation, Start and Stop  


### Download apache-zookeeper-3.5.6-bin.tar.gz from 

	http://apachemirror.wuchna.com/zookeeper/zookeeper-3.5.6/


### Apache ZooKeeper Installation

	### Unzip the tar
	$ tar -zxf apache-zookeeper-3.5.6-bin.tar.gz
	
### Apache ZooKeeper Configuration	
	
	### Rename the zoo_sample.cfg and configure according to your usage
	$ << create data folder and configure ../conf/zoo.cfg >>

### Apache ZooKeeper Server Start

	### Start ZooKeeper Server 	
	$ ./bin/zkServer.sh start /java/Apache/ZooKeeper/apache-zookeeper-3.5.6-bin/conf/zoo.cfg

### Apache ZooKeeper CLI Start

	### Start ZooKeeper CLI
	$ ./bin/zkCli.sh
	
### Apache ZooKeeper Server Stop	
	
	### Stop ZooKeeper Server
	$ ./bin/zkServer.sh stop
	
## Apache ZooKeeper Commands

### Help Command	
	$ help
	
### List All Znodes Command
	$ ls /

### Create New Znode Command
	$ create /MyTest_Zookeeper_Znode "my data goes here"

### Get Znode Data Command
	$ get /MyTest_Zookeeper_Znode

### Add Data into Znode Command
	$ set /MyTest_Zookeeper_Znode "my extra data goes here"

### Delete Znode Command
	$ delete /MyTest_Zookeeper_Znode

### Sequential Znode
	$ create -s /MyTest_SequentialZnode "This is a Sequential Znode"

### Ephemeral Znode
	$ create -e /MyTest_EphemeralZnode "This is an Ephemeral ZNode"

### Watch Znode
	$ get -w /MyTest_Zookeeper_Znode

### Create Parent-Child & Sub Znodes
	$ create /zoo "The parent Znode"
	$ create /zoo/animal "The parent > child Znode"
	$ create /zoo/animal/lion "The parent > child > sub Znode"
	$ create /zoo/animal/tiger "The parent > child > sub Znode"
	$ create /zoo/animal/elephant "The parent > child > sub Znode"

	$ create /zoo/bird "The parent > child Znode"
	$ create /zoo/bird/macaw "The parent > child > sub Znode"
	$ create /zoo/bird/seagull "The parent > child > sub Znode"
	$ create /zoo/bird/koel "The parent > child > sub Znode"

### List Child ZNodes
	$ ls /zoo			(Output: [animal, bird] )

### List Sub ZNodes
	$ ls /zoo/animal			(Output: [elephant, lion, tiger] )

### Get Data From Child ZNodes
	$ get /zoo/bird		(Output: The parent > child Znode )

### Get Data From Sub ZNodes
	$ get /zoo/bird/seagull			(Output: The parent > child > sub Znode )

### Check Status of a Znode
	$ stat /zoo
	$ stat /zoo/animal

### Delete Sub Znode
	$ delete /zoo/animal/tiger

### Delete Child Znode
	$ delete /zoo/animal

### Delete Parent Znode
	$ delete /zoo

### Delete All Parent > Child > Sub Znodes
	$ deleteall /zoo
	

# Approach 1

### 1. Run Executor.java	 to get data from a Znode


# Approach 2

### Run following java programs to connect with Apache ZooKeeper server


### 1. Run ExistsZnode.java	 to check a Znode
	

### 2. Run CreateZnode.java to create a new Znode


### 3. Run SetZnode.java to add/update data in a Znode


### 4. Run GetZnode.java to get data from a Znode


### 5. Run GetChildrenZnode.java to get/list all the child Znodes in a Znode


### 6. Run DeleteZnode.java	 to delete Znode





