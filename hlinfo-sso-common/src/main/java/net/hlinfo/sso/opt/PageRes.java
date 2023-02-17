package net.hlinfo.sso.opt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.nutz.castor.Castors;
import org.nutz.dao.pager.Pager;

public class PageRes<T> implements Serializable {

    private static final long serialVersionUID = 5104522523949248573L;
    private List<T> list;
    private Pager pager;

    /**
     * 新建一个分页查询的结果集合
     */
    public PageRes() {}

    /**
     * 一个分页查询的结果集合
     * @param list 查询结果
     * @param pager 分页对象
     */
    public PageRes(List<T> list, Pager pager) {
        this.list = list;
        this.pager = pager;
    }

    /**
     * 获取结果集
     * @return 结果集
     */
    public List<?> getList() {
        return list;
    }

    /**
     * 按特定泛型获取结果集,属于直接强转,不带转换
     * @param eleType 泛型
     * @return 结果集
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> getList(Class<T> eleType) {
        return (List<T>) list;
    }

    /**
     * 转换为特定类型的结果集
     * @param eleType 新的结果集
     * @return 特定类型的结果集
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> convertList(Class<T> eleType) {
        if (null == list || list.isEmpty())
            return (List<T>) list;

        List<T> re = new ArrayList<T>(list.size());
        Castors castors = Castors.me();
        for (Object obj : list)
            re.add(castors.castTo(obj, eleType));

        return re;
    }

    /**
     * 设置结果集
     * @param list 结果集
     * @return 当前对象,用于链式调用
     */
    public PageRes<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    /**
     * 获取分页对象
     * @return 分页对象
     */
    public Pager getPager() {
        return pager;
    }

    /**
     * 设置分页对象
     * @param pager 分页对象
     * @return 当前对象,用于链式调用
     */
    public PageRes<T> setPager(Pager pager) {
        this.pager = pager;
        return this;
    }
}
