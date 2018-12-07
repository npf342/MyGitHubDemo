package com.kgc.dsj02;
import com.kgc.dsj02.Util.HBaseConfigUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class InsertIntoTable {
    public static void main(String[] args){
        Configuration config=HBaseConfigUtil.getHBaseConfiguration();
        Connection connection=null;
        Admin admin=null;
        try {
            connection=ConnectionFactory.createConnection(config);
            admin=connection.getAdmin();
            String tableName="peoples";
            if(!admin.isTableAvailable(TableName.valueOf(tableName))){
                HTableDescriptor hbaseTable=new HTableDescriptor(TableName.valueOf(tableName));
                hbaseTable.addFamily(new HColumnDescriptor("name"));
                hbaseTable.addFamily(new HColumnDescriptor("contactininfo"));
                hbaseTable.addFamily(new HColumnDescriptor("personalinfo"));
                admin.createTable(hbaseTable);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
               if(admin!=null)  {
                    admin.close();
                }
                if(connection!=null&&!connection.isClosed()){
                    connection.close();
                }
            } catch (Exception e2){
                e2.printStackTrace();
            }

        }

    }
}
