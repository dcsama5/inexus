package com.inexus_task.exceptions;

import com.inexus_task.Node;

public class NodeNonExistantAtPointException extends Exception {
	
	public NodeNonExistantAtPointException(Node node) {
		super("Node does not exist at " + node);
	}

}
