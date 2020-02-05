package com.example.apache.zookeeper.client.approach2;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class GetZnode {

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
			Stat stat = zoo.exists(path, true); // Stat checks the path of the znode

			if (stat != null) {
				byte[] b = zoo.getData(path, new Watcher() {

					public void process(WatchedEvent we) {

						if (we.getType() == Event.EventType.None) {
							switch (we.getState()) {
							case Expired:
								connectedSignal.countDown();
								break;
							}

						} else {
							String path = "/zookeeper_test_1";

							try {
								byte[] bn = zoo.getData(path, false, null);
								String data = new String(bn, "UTF-8");
								System.out.println(data);
								connectedSignal.countDown();

							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}
					}
				}, null);

				String data = new String(b, "UTF-8");
				System.out.println(data);
				connectedSignal.await();

			} else {
				System.out.println("Node does not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
