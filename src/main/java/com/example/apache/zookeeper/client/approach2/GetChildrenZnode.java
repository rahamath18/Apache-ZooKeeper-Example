package com.example.apache.zookeeper.client.approach2;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class GetChildrenZnode {

	public static void main(String args[]) throws IOException, InterruptedException {

		String host = "localhost";
		int sessionTimeout = 5000;
		String path = "/zookeeper_test_1"; // Znode path & name

		final CountDownLatch connectedSignal = new CountDownLatch(1);
		ZooKeeper zoo = new ZooKeeper(host, sessionTimeout, new Watcher() {

			public void process(WatchedEvent we) {

				if (we.getState() == KeeperState.SyncConnected) {
					connectedSignal.countDown();
				}
			}
		});

		connectedSignal.await();

		try {
			Stat stat = zoo.exists(path, true); // Stat checks the path
			if (stat != null) {
				List<String> children = zoo.getChildren(path, false);
				for (int i = 0; i < children.size(); i++)
					System.out.println(children.get(i)); // Print children's
			} else {
				System.out.println("Node does not exists");
			}
			zoo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
