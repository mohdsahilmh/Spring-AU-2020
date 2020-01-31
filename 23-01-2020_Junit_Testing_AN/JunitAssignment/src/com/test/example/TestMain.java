package com.test.example;

import org.junit.Test;
import org.mockito.InOrder;

public class TestMain {
public static void main(String args[]) {
	TestApp testapp = new TestApp();
	testapp.add(10, 20);
	testapp.sub(40, 10);
	testapp.mul(10, 2);
	testapp.div(10, 2);
}
}
