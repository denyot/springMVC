import com.hu.springMVC.QueryObject;
import com.hu.springMVC.User;
import com.hu.springMVC.UserMapper;
import com.hu.springMVC.Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    @Test
    public void testSave() throws Exception {
        User u = new User();
        u.setPassword("123");
        u.setUsername("美女");
        SqlSession openSession = MyBatisUtil.getSqlSession();
//        openSession.insert("com/hu/springMVC/UserMapper.save", u);
        openSession.getMapper(UserMapper.class).save(u);
        openSession.commit();
        openSession.close();
        System.out.println(u);
    }

    @Test
    public void testUpdate() throws Exception {
        User u = new User();
        u.setId(6l);
        u.setPassword("2");
//        u.setUsername("2");
        SqlSession openSession = MyBatisUtil.getSqlSession();
        openSession.getMapper(UserMapper.class).update(u);
        openSession.commit();
        openSession.close();
        System.out.println(u);
    }

    @Test
    public void testDelete() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
//        openSession.delete("com/hu/springMVC/UserMapper.delete", 1l);
        openSession.getMapper(UserMapper.class).delete(5l);
        openSession.commit();
        openSession.close();
    }

    @Test
    public void testGet() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
//        User user = openSession.selectOne("com/hu/springMVC/UserMapper.get", 3l);
        openSession.getMapper(UserMapper.class).get(5l);
        openSession.close();
    }

    @Test
    public void testList() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        List<User> users = openSession.getMapper(UserMapper.class).list();
        openSession.close();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQuery() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        QueryObject qo = new QueryObject();
        qo.setKeyword("美女2");
        qo.setBeginPass(30);
        qo.setEndPass(40);
        List<User> users = openSession.getMapper(UserMapper.class).query(qo);
        openSession.close();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryByIn() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        List<Long> list = new ArrayList();
        list.add(1l);
        list.add(6l);
        list.add(8l);
        list.add(12l);
        List<User> users = openSession.getMapper(UserMapper.class).queryByIn(list);
        openSession.close();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLogin() throws Exception {
        SqlSession openSession = MyBatisUtil.getSqlSession();
        User user = openSession.getMapper(UserMapper.class).login("2", "2");
        openSession.close();
        System.out.println(user);
    }
}
