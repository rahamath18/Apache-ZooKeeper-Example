package com.example.apache.zookeeper.client.approach2;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class SetZnode {

	public static void main(String args[]) throws IOException, InterruptedException {
		
		String host = "localhost";
		int sessionTimeout = 5000;
		String path = "/zookeeper_test_1"; // Znode path & name
		byte[] data = ("This is new data for znode zookeeper_test_1" + new Date().toString()).getBytes();

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
			zoo.setData(path, data, zoo.exists(path,true).getVersion());
			zoo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
