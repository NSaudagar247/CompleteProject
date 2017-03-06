package com.application.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
//import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;

import com.application.model.Blog;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class TestJsonAppendMine {

	static String filepath="";

public TestJsonAppendMine() {
	filepath = System.getProperty("user.dir")+"/src/main/webapp/resources/modules/blog/blogs.json";
}
	
int addBlog(Blog blog){
	File myfile = new File(filepath);
	ObjectMapper mapper = new ObjectMapper();
	TestJsonAppendMine obj = new TestJsonAppendMine();

	if(myfile.exists()){
		System.out.println("File Present @ "+ myfile.getAbsolutePath() +myfile.getName());
		 List<Blog> list = obj.getAllBlogs();
		 
		 System.out.println("All Blogs = "+list);
		 System.out.println("New Blogs = "+blog);

//		 TypeReference<List<Blog>> mapType = new TypeReference<List<Blog>>() {};
//	    	List<Blog> jsonToBlogList = mapper.readValue(list.toArray(), mapType);
//	    	
//		 list.forEach(System.out::println);
		 
//System.out.println("list fir st blog : "+list.get(0));		 
//System.out.println("adding blog : "+blog);

//		 list = mapper.convertValue(list, new TypeReference<List<Blog>>() { });

//		 Blog pojo = mapper.convertValue((Blog)list.get(0), Blog.class);
		 
//		 System.out.println("First Blog Title - "+((Blog)list.get(0)).getTitle());
		 
		boolean flag = false;
		for (Blog existingblog : list) {
			if(existingblog.getTitle().equals(blog.getTitle())){
				flag = true;
				break;
			}
		}
		 
		 if(flag){
			 System.out.println("Blog already present");
		 }
		 else{
			list.add(blog);
			try {
				String json2 = mapper.writeValueAsString(list);
				Files.write(myfile.toPath(), Arrays.asList(json2), StandardOpenOption.WRITE);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println("New Record Inserted");
		 }
	}
	else{
		System.out.println("File not Present @ "+myfile.getAbsolutePath() +myfile.getName());
		List<Blog> list = new ArrayList<Blog>();
		list.add(blog);
		String json2;
		try {
			json2 = mapper.writeValueAsString(list);
			 Files.write(myfile.toPath(), Arrays.asList(json2), StandardOpenOption.CREATE);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return 0;
}

List<Blog> getAllBlogs(){
//	 ObjectMapper mapper = new ObjectMapper();
//	 mapper.configure(SerializationConfig.Feature.AUTO_DETECT_FIELDS, true);
	 List<Blog> list = new ArrayList<Blog>();
//
//	 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 try {
//		list = mapper.readValue(new FileInputStream(filepath), ArrayList.class );

		 com.fasterxml.jackson.databind.ObjectMapper bmapper = new com.fasterxml.jackson.databind.ObjectMapper();
		
		list = bmapper.readValue(new FileInputStream(filepath),
				TypeFactory.defaultInstance().constructCollectionType(List.class,  
				   Blog.class));
		System.out.println("myobjects : "+list);

	
		
//		List<Blog> myObjects = Arrays.asList(mapper.readValue(list.toString(), Blog[].class));
//System.out.println("myobjects : "+myObjects);

//		com.fasterxml.jackson.databind.ObjectMapper objmapper = new com.fasterxml.jackson.databind.ObjectMapper();
//		List<Blog> myObjects = objmapper.readValue(new FileInputStream(filepath), new TypeReference<List<Blog>>(){});
//		List<Blog> myObjects = mapper.readValue(new FileInputStream(filepath), mapper.getTypeFactory().constructCollectionType(List.class, Blog.class));

//		TypeReference<ArrayList<Blog>> mapType = new TypeReference<ArrayList<Blog>>() {};
//    	List<Blog> jsonToBlogList = mapper.readValue(new FileInputStream(filepath), mapType);
//    	System.out.println("\n2. Convert JSON to List of Blog objects : "+myObjects);

		
	} catch (IOException e) {
		e.printStackTrace();
	}
	 System.out.println("List : "+list);
	return list;
}
	
//	public List<?> readJSONToList(String jsonValue,Class<?> type){
//
//		ObjectMapper objectMapper = new ObjectMapper();
//	    List<?> objDTOS=null;
//	    try {
//	        //get json content without root name
//	        JsonNode root= objectMapper.readTree(jsonValue).get(getRootName());
//	        TypeFactory tf = objectMapper.getTypeFactory();
//	        JavaType listOfObjs = tf.constructCollectionType(ArrayList.class,type);
//	        objDTOS=objectMapper.readValue(root.traverse(), listOfObjs);
//
//	    } catch (NullPointerException e) {
//	        Logger.write("Jackson Json List Reader", e.getMessage(), Logger.ERROR);
//	    } catch (JsonParseException e) {    
//	        Logger.write("Jackson Json List Reader", e.getMessage(), Logger.ERROR);
//	    } catch (IOException e) {
//	        Logger.write("Jackson Json List Reader", e.getMessage(), Logger.ERROR);
//	    }
//	    return  objDTOS;
//	}	

public void getPath() throws UnsupportedEncodingException {
//String path = this.getClass().getClassLoader().getResource("").getPath();
//String fullPath = URLDecoder.decode(path, "UTF-8");
//String pathArr[] = fullPath.split("/target/classes/");
//System.out.println(fullPath);
//System.out.println(pathArr[0]);
//fullPath = pathArr[0].substring(1);
////String reponsePath = "";
//
//System.out.println("fullPath : "+fullPath);

	String path = this.getClass().getClassLoader().getResource("").getPath();
	String fullPath;
		fullPath = URLDecoder.decode(path, "UTF-8");
	String pathArr[] = fullPath.split("/target/classes/");
//	System.out.println(fullPath);
//	System.out.println(pathArr[0]);
	fullPath = pathArr[0].substring(1);
	System.out.println("fullPath : "+fullPath);
	filepath = fullPath.concat("/src/main/webapp/resources/modules/blog/blogs.json");
	System.out.println(filepath);
	
// to read a file from webcontent
//reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
}

	public static void main(String[] args) throws IOException {

		Blog blog=new Blog("Title 2", "Story 2", "Laghupathi", new Date());
	new TestJsonAppendMine().addBlog(blog);
		
//		System.out.println(new TestJsonAppendMine().getAllBlogs());
		
//		 String PROJECT_ROOT_PATH = System.getProperty("user.dir");
//		 File myfile = new File(PROJECT_ROOT_PATH+"/src/main/webapp/resources/modules/blog/blogs.json");
//
//		ObjectMapper mapper = new ObjectMapper();
//		
////		String lines = Files.readAllLines(myfile.toPath()).toString();
//		String lines = "{\"Blog\":[{\"title\": \"MyTestBlogTitle_1\",\"story\": \"MyTestBlogStory_1\"}{\"title\": \"MyTestBlogTitle_2\",\"story\": \"MyTestBlogStory_2\"}]}";	
		
//		System.out.println(lines);
//
//		List<Blog> list = mapper.readValue(lines,
//				TypeFactory.defaultInstance().constructCollectionType(List.class,
//				   Blog.class));
//
//		System.out.println("List : "+list);
//		
//		org.svenson.JSONParser parser = new org.svenson.JSONParser();
//        parser.addTypeHint(".blogs[]", Blog.class);
//        
//        parser.addTypeHint("blogs[]", Blog.class);
//        Map<String, List<Blog>> result1 = parser.parse(Map.class, lines);
//        for (Entry<String, List<Blog>> entry : result1.entrySet()) {
//            for (Blog Blog : entry.getValue()) {
//                System.out.println("VALUE :->" + Blog.getTitle());
//            }
//        }
//        
//        
		//converting json to Map
//		byte[] mapData = Files.readAllBytes(Paths.get("data.txt"));
//		Map<String,String> myMap = new HashMap<String, String>();
//
//		ObjectMapper objectMapper = new ObjectMapper();
////		myMap = objectMapper.readValue(lines, HashMap.class);
////		System.out.println("Map is: "+myMap);
//
//		JsonFactory jsonFactory = new JsonFactory();
//		JsonParser jp = jsonFactory.createJsonParser(myfile);
//		
//		//another way
////		final TypeReference<Map<String, String>> typeRef = new TypeReference<Map<String, String>>() {};
//		TypeReference<List<Blog>> typeRef = new TypeReference<List<Blog>>(){};	
////		myMap = objectMapper.readValues
////		System.out.println("Map using TypeReference: "+myMap);		
////		 Iterator<Map<String, String>> it = objectMapper.readValues(lines, typeRef);
//		JsonNode node = mapper.readTree(lines);
//		List<Blog> list = mapper.readValue(node.traverse(), typeRef);
//        for (Blog f : list) {
//            System.out.println(f);
//        }
//		TypeReference<List<Blog>> tRef = new TypeReference<List<Blog>>() {};
//		 MappingIterator<Blog> it= objectMapper.readValues(jp, Blog.class);

//		List<Blog> list = mapper.readValue(lines, new TypeReference<List<Blog>>(){});
//		System.out.println("List"+it);

		
//		JsonFactory jsonFactory = new JsonFactory();
//		JsonParser jp = jsonFactory.createJsonParser(myfile);
//		jp.setCodec(new ObjectMapper());
//		JsonNode jsonNode = jp.readValueAsTree();
//		readJsonData(jsonNode);


//		ObjectMapper mapper = new ObjectMapper();
//	    JsonFactory f = new JsonFactory();
//	    List<Blog> lstBlog = null;
//	    JsonParser jp = f.createJsonParser(myfile);
//		
//	 	com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
//    	//Set pretty printing of json
//    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);		
////		TypeReference<List<Blog>> mapType = new TypeReference<List<Blog>>() {};
//
//		
//		TypeReference<List<Blog>> tRef = new TypeReference<List<Blog>>() {};
////	    lstBlog = objectMapper.readValue(jp, tRef);
////	    for (Blog Blog : lstBlog) {
////	        System.out.println(Blog.toString());
////	    }
//
//	    objectMapper.writerWithType(new TypeReference<List
//	            <Blog>>() {
//	            }).writeValue(System.out, lstBlog);
//	    
		//    	List<Blog> jsonToBlogList = objectMapper.readValue(jp.readValueAsTree().asText(), mapType);
//    	System.out.println("\n2. Convert JSON to List of Blog objects :"+jsonToBlogList);

//    	List<Blog> myObjects = objectMapper.readValue(jp.readValueAsTree().asText(), objectMapper.getTypeFactory().constructCollectionType(List.class, Blog.class));
//    	System.out.println("\n2. Convert JSON to List of Blog objects :"+myObjects );

    	
    	
		
//		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
//		
//		TypeReference
//
//		TypeReference<List<Blog>> tRef = new TypeReference<List<Blog>>() {};
//		
//		List<Blog> myObjects = mapper.readValue(jsonInput, new TypeReference<List<Blog>>(){});
//
		
//		 final ObjectMapper mapper = new ObjectMapper();
//
//		 String PROJECT_ROOT_PATH = System.getProperty("Blog.dir");
//		 System.out.println("PROJECT_ROOT_PATH"+PROJECT_ROOT_PATH);
//
//		 File myfile = new File(PROJECT_ROOT_PATH+"/src/main/webapp/resources/modules/blog/blogs.json");
//		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		 Blog blog = mapper.readValue(new FileInputStream(PROJECT_ROOT_PATH+"/src/main/webapp/resources/modules/blog/blogs.json"), Blog.class );
//		 System.out.println("Title : "+blog.getTitle()+", Story : "+ blog.getStory());
		 
//		 final File myfile = new File("D:/temp/TestJSON2.json");

//		 final String json2 = mapper.writeValueAsString(new Blog("Dummy Blog Title 3", "Dummy Blog Story 3"));
//
//		 if(!myfile.exists()){
//			 Files.write(myfile.toPath(), Arrays.asList(json2), StandardOpenOption.CREATE);
//			 System.out.println("File doesnt exists.. File created with one record");
//		 }
//		 else{
//
//			 final List<String> lines = Files.readAllLines(myfile.toPath());
//			 
//			 if(!lines.contains(json2)){
//				 Files.write(myfile.toPath(), Arrays.asList(json2), StandardOpenOption.APPEND);
//				 System.out.println("New Record Inserted");
//			 }
//			 else{
//				 System.out.println("Record Already Exists");
//			 }
//			 
////			 System.out.println("lines.size() = "+lines.size());
//		 }
		 
		 // Write it to the file myfile.json. 
		 // The first time the file is created and the content is NOT appended
//		 Files.write(new File("D:/temp/TestJSON.json").toPath(), Arrays.asList(json1), StandardOpenOption.CREATE);


		}

	
//	static void readJsonData(JsonNode jsonNode) {
//		Iterator <Map.Entry<String, JsonNode>> ite = jsonNode.getFields();
//		while(ite.hasNext()){
//			Map.Entry<String, JsonNode> entry = ite.next();
//			if(entry.getValue().isObject()) {
//				readJsonData(entry.getValue());
//			} else {
//			    System.out.println("key:"+entry.getKey()+", value:"+entry.getValue());
//			}
//		}
//	}
}
