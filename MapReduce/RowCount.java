import java.io.IOException;

public class RowCount {

  public static class RowMapper // Mapper Class ﻿
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1); // 1
    private Text msg = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
    	/* 해당 함수가 돌아간다는 것은 한 행 이상이 존재한다는 의미 */
    	
    	String row = value.toString();
    	if (row != null && !row.equals("") && !row.equals(" ")) {
    		msg.set("row count");
    		context.write(msg, one);
    		/* shuffle로 넘어가 key-value list로 생성
    		 * ex. ("row count", [1,1,1,1....]) */
    	}   	
    }
  }

  public static class TotalRowsReducer // Reduce Class
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, 
    								/*동일한 key값의 value가 list로 넘어옴*/
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) { //각 객체의 value값은 1
        sum += val.get(); //반복문 돌려 각 values list의 원소(1)를 sum에 누적
      }
      result.set(sum); //총 행(row)수
      context.write(key, result); //파일에 덮어쓰기
    }
  }

  public static void main(String[] args) throws Exception { // Main Class to perform above codes
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "row count"); // JOb(MapReduce Task) 객체화
    job.setJarByClass(RowCount.class); // .class : 자바 클래스정보를 객체로 전달
    job.setMapperClass(RowMapper.class); //각 노드별로 실행된 데이터 전달
    job.setCombinerClass(TotalRowsReducer.class);
    job.setReducerClass(TotalRowsReducer.class); //Reduce: 최종취합
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0])); //처리할 데이터가 있는 dir전달
    /*main 함수의 argument는 command line으로 전달
      ex) ﻿hadoop jar test/rc.jar /user/rc/input /user/rc/output */
    FileOutputFormat.setOutputPath(job, new Path(args[1])); //결과를 저장할 출력 dir전달
    System.exit(job.waitForCompletion(true) ? 0 : 1); //자바 VM 종료하는 방법
  }
}
