package com.naveen.dcleaner.testing;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.misc.Launcher;

public class LauncherTesting {

	WatchService wservice ;
		
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before
	public void setUp() throws Exception {
		Path mypath = Paths.get("C:\\Users\\Naveen\\Desktop\\Testing");
		wservice = mypath.getFileSystem().newWatchService();
		mypath.register(wservice, ENTRY_CREATE);
		mypath.register(wservice, ENTRY_MODIFY);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		Launcher lobj = new Launcher();		
	}

}
