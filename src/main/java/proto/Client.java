package proto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import proto.Person.PersonMsg;

/**
 * Protobuf 序列化/反序列化测试
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		PersonMsg.Builder builder = PersonMsg.newBuilder();
		builder.setId(1);
		builder.setName("skywalker");
		builder.setEmail("xsdwem7@hotmail.com");
		builder.addFriends("Tom");
		builder.addFriends("Jack");
		Person.PersonMsg personMsg = builder.build();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		personMsg.writeTo(baos);
		
		//反序列化
		byte[] data = baos.toByteArray();
		PersonMsg result = PersonMsg.parseFrom(data);
		System.out.println("id: " + result.getId());
		System.out.println("name: " + result.getName());
		System.out.println("email: " + result.getEmail());
		for (String friend : result.getFriendsList()) {
			System.out.println("friend: " + friend);
		}
	}
	
}