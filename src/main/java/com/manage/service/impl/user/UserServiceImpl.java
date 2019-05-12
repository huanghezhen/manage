package com.manage.service.impl.user;

import com.manage.config.Const;
import com.manage.dao.user.UserMapper;
import com.manage.entity.Ret;
import com.manage.entity.table.User;
import com.manage.entity.user.UserLoginModel;
import com.manage.service.iface.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 14:32
 */
@Service
public class UserServiceImpl implements UserService
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;
    @Override
    public Ret login(UserLoginModel userLoginModel, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Const.SESSION_CODE);
        if (code == null || userLoginModel.getCode() == null || !code.equals(userLoginModel.getCode())){
            return Ret.getRet(Const.failedEnum.SESSION_CODE_FAILED.getCode(),Const.failedEnum.SESSION_CODE_FAILED.getMsg());
        }
        User user = userMapper.getUser(userLoginModel.getUserCode());
        if (user == null){
            return Ret.getRet(Const.failedEnum.UNUSER.getCode(),Const.failedEnum.UNUSER.getMsg());
        }
        if (userLoginModel.getUserPasswd() == null || !userLoginModel.getUserPasswd().equals(user.getUserPasswd())){
            return Ret.getRet(Const.failedEnum.UNPASSWD.getCode(),Const.failedEnum.UNPASSWD.getMsg());
        }
        session.setAttribute(Const.SESSION_USER,user);
        return Ret.getRet();
    }

    @Override
    public Ret home(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.SESSION_USER);
        Ret<User> ret = Ret.getRetT(user);
        return ret;
    }

    @Override
    public Ret logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute(Const.SESSION_USER);
        return Ret.getRet();
    }

    @Override
    public void getCode(HttpServletRequest request, HttpServletResponse response)
    {
        response.reset();
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        int width = 44, height = 18;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        logger.info("Graphics:"+g.toString());
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.BOLD, 18));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 80; i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String sRand = "";
        int RandNum = 15;
        int UpNum = 18;
        int DownNum = 14;
        RandNum = random.nextInt(10);
        for (int i = 0; i < 4; i++)
        {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            //g.setColor(Color.BLACK);
            if (RandNum % 2 == 0)
            {
                if ((i == 1) || (i == 3))
                {
                    g.drawString(rand, 10 * i + 4, UpNum);
                }
                else
                {
                    g.drawString(rand, 10 * i + 4, DownNum);
                }
            }
            else
            {
                if ((i == 1) || (i == 3))
                {
                    g.drawString(rand, 10 * i + 4, DownNum);
                }
                else
                {
                    g.drawString(rand, 10 * i + 4, UpNum);
                }
            }
        }
        logger.info("sRand : " + sRand);
        HttpSession session = request.getSession();
        session.setAttribute(Const.SESSION_CODE, sRand);
        g.dispose();
        try
        {
            ImageIO.write(image, "JPEG", response.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private Color getRandColor(int StartNumC, int EndNumC)
    {
        Random random = new Random();
        if (StartNumC > 255)
            StartNumC = 255;
        if (EndNumC > 255)
            EndNumC = 255;
        int r = StartNumC + random.nextInt(EndNumC - StartNumC);
        int g = StartNumC + random.nextInt(EndNumC - StartNumC);
        int b = StartNumC + random.nextInt(EndNumC - StartNumC);
        return new Color(r, g, b);
    }
}
