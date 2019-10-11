package com.aoto.framework.security.web.Util;



import java.io.*;
import java.util.*;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

public class FtpJSch {
    private Session session;

    private static ChannelSftp sftp = null;

    //账号

    private static String user="root";
    //主机ip

    private static String host ="122.112.252.101";
    //密码

    private static String password="Asenseof7.";
    //端口

    private static int port=22;
    //上传地址
    private static String directory ;
    //下载目录
    private static String saveFile ;

    public static FtpJSch getConnect(){
        FtpJSch ftp = new FtpJSch();
        try {
            JSch jsch = new JSch();
            //获取sshSession  账号-ip-端口
            Session sshSession =jsch.getSession(user, host,port);
            //添加密码
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");

            sshSession.setConfig(sshConfig);
            //开启sshSession链接
            sshSession.connect();
            //获取sftp通道
            Channel channel = sshSession.openChannel("sftp");
            //开启
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ftp;
    }
    /**
     * 关闭Ftp连接
     *
     * @throws IOException
     */
    public void closeFptConnect()
    {
        if (sftp != null)
        {
            if (sftp.isConnected())
            {
                sftp.disconnect();
            }
        }
        if (session != null)
        {
            if (session.isConnected())
            {
                session.disconnect();

            }
        }
    }

    /**
     *
     * @param uploadPath 上传文件的路径
     * @return 服务器上文件名
     */
    public void upload(MultipartFile file,String uploadPath) throws IOException, SftpException {
        createDir(uploadPath);
        InputStream inputStream = null;
        inputStream = file.getInputStream();
        String abc=file.getOriginalFilename();
        sftp.put(inputStream,file.getOriginalFilename());
        inputStream.close();
    }

    /**
     *
     * @param downloadFileName
     */
    public void download(String downloadFileName) {
        try {
            sftp.cd(directory);

            File file = new File(saveFile);

            sftp.get(downloadFileName, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除文件
     * @param deleteFile  文件名
     * @param uploadPath  路径
     */
    public void delete(String deleteFile,String uploadPath) {
        try {
            sftp.cd(uploadPath);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletedir(String uploadPath) throws SftpException {

            List<ChannelSftp.LsEntry> list=sftp.ls(uploadPath);
            list.remove(0);
            list.remove(list.size()-1);
            list.stream().forEach(s-> {
                try {
                    sftp.rm(uploadPath+s.getFilename());
                } catch (SftpException e) {
                    e.printStackTrace();
                }
            });
            sftp.rmdir(uploadPath);
    }


    /**
     *
     * @param directory  目录
     * @return
     * @throws SftpException
     */
    public Vector listFiles(String directory)
            throws SftpException {
        return sftp.ls(directory);
    }

    /**
     * 创建循环创建文件目录
     *
     * @param uploadPath 上传目录
     * @throws SftpException
     */
    public void createDir(String uploadPath)
            throws SftpException
    {
        if(!isExistDir(uploadPath))
        {
            String pathArry[] = uploadPath.split("/");

            StringBuffer filePath = new StringBuffer("/");

            for (String path : pathArry)
            {
                if (path.equals(""))
                {
                    continue;
                }

                filePath.append(path + "/");

                if (isExistDir(filePath.toString()))
                {
                    sftp.cd(filePath.toString());
                }
                else
                {
                    // 建立目录
                    sftp.mkdir(filePath.toString());

                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }
            }
        }
    }


    /**
     * 目录是否存在
     * @param path
     * @return
     */
    private boolean isExistDir(String path)
    {
        try
        {
            sftp.cd(path);

            return true;
        }
        catch (SftpException e)
        {
            return false;
        }
    }

}
