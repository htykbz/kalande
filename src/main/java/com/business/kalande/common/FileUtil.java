package com.business.kalande.common;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class FileUtil {
    public static final String ROOT = "files";
    private final ResourceLoader resourceLoader;

    public FileUtil(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 文件上传
     * @throws IOException
     */
    @RequestMapping(value="/fileUpload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> oneFileUpload(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        String uuid= UUID.randomUUID().toString();
        Map<String, Object> json = new HashMap<String, Object>();
        String id = request.getSession().getId();
        // 获得原始文件名
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = null;
        Map map =multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            file=(MultipartFile) map.get(obj);

        }
        /** 获取文件的后缀* */
        String fileName = file.getOriginalFilename();
        id = id + fileName;
        if("".equals(fileName)){
            json.put("fileUrl", "");
            resp.getWriter().println(json.toString());
        }else{
            System.out.println("原始文件名:" + fileName);

            // 上传位置
            String path = "files/"; // 设定文件保存的目录  (项目绝对路径)
            File f = new File(path);
            if (!f.exists())
                f.mkdirs();
            if (!file.isEmpty()) {
                try {
                    if(!"".equals(uuid)&&uuid!=null){
                        String[] split = fileName.split("\\.");
                        fileName =split[split.length-2]+"("+uuid+")."+split[split.length-1];//文件名添加uuid  防止名称重复
                    }
                    //向单例哈希表写入文件长度和初始进度
                    //文件进度长度
                    long progress = 0;
                    FileOutputStream fos = new FileOutputStream(path + fileName);
                    InputStream in = file.getInputStream();
                    byte[] buffer = new byte[1024];
                    int readNumber = 0;
                    while((readNumber = in.read(buffer)) != -1){
                        //每读取一次，更新一次进度大小
                        progress = progress + readNumber;
                        fos.write(buffer);
                    }
                    fos.flush();
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + fileName);
            // 保存文件地址，用于JSP页面回显
            json.put("fileName", fileName);
            json.put("uploadUrl", path);
            json.put("fileSize", file.getSize());
        }
        return json;
    }

    /**
     * 文件上传
     * @throws IOException
     */
    @RequestMapping(value="/ckEditorFileUpload",method = RequestMethod.POST)
     public void ckEditorFileUpload(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String uuid= UUID.randomUUID().toString();
        String id = request.getSession().getId();
        // 获得原始文件名
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = null;
        Map map =multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            file=(MultipartFile) map.get(obj);

        }
        /** 获取文件的后缀* */
        String fileName = file.getOriginalFilename();
        id = id + fileName;
        if("".equals(fileName)){
            out.println("");
        }else{
            System.out.println("原始文件名:" + fileName);

            // 上传位置
            String path = "files/"; // 设定文件保存的目录  (项目绝对路径)
            File f = new File(path);
            if (!f.exists())
                f.mkdirs();
            if (!file.isEmpty()) {
                try {
                    if(!"".equals(uuid)&&uuid!=null){
                        String[] split = fileName.split("\\.");
                        fileName =split[split.length-2]+"("+uuid+")."+split[split.length-1];//文件名添加uuid  防止名称重复
                    }
                    //向单例哈希表写入文件长度和初始进度
                    //文件进度长度
                    long progress = 0;
                    FileOutputStream fos = new FileOutputStream(path + fileName);
                    InputStream in = file.getInputStream();
                    byte[] buffer = new byte[1024];
                    int readNumber = 0;
                    while((readNumber = in.read(buffer)) != -1){
                        //每读取一次，更新一次进度大小
                        progress = progress + readNumber;
                        fos.write(buffer);
                    }
                    fos.flush();
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + fileName);
            String uploadUrl = path + fileName;
            String callback = request.getParameter("CKEditorFuncNum");
            String script = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + callback + ", '" + fileName + "');</script>";
            out.println(script);
            out.flush();
            out.close();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

