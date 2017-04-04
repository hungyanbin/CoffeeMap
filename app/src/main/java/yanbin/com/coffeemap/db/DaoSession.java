package yanbin.com.coffeemap.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import yanbin.com.coffeemap.db.Shop;

import yanbin.com.coffeemap.db.ShopDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig shopDaoConfig;

    private final ShopDao shopDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        shopDaoConfig = daoConfigMap.get(ShopDao.class).clone();
        shopDaoConfig.initIdentityScope(type);

        shopDao = new ShopDao(shopDaoConfig, this);

        registerDao(Shop.class, shopDao);
    }
    
    public void clear() {
        shopDaoConfig.clearIdentityScope();
    }

    public ShopDao getShopDao() {
        return shopDao;
    }

}
