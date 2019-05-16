# Commom组件
## 用于快速搭建一个项目所需的代码和依赖.包含如下依赖:
### Glide 图片加载框
### Glide 的使用【待补充】
### Logger 日志打印框架 
### Logger 的使用【待补充】
### Gson json格式转换框架
### Gson 的使用【待补充】
### retrofit 网络请求整合框架
### retrofit 的使用【待补充】
### rxjava 异步框架
### rxjava 的使用【待补充】


## Commom组件中自己的公共组件如下：

### MVP组件
### MVP 的使用
【View和Presenter互相持有软引用 避免造成内存泄露】
Contact是用于关联View和Presenter的类，统一管理相应的方法和类
```java
    public class MainContact {
        public interface IMain extends IView {
            //例如 View负责展示客服电话
            void showTel(String tel);
        }
    
        public interface IMainPre extends IPresenter {
            //列入 Presenter负责网络请求获取客服电话
            void getTel();
        }
    }
```

View 是用于负责展示数据。业务逻辑全部交给Presenter处理。
```java
    public class MainActivity extends BaseActivity<MainPresenter> implements MainContact.IMain {
        //、、、省略初始化view的过程和其他业务逻辑代码    
    @Override
        public void showTel(String tel) {
            telText.setText(tel);//展示
        }
        @Override //初始化当前View对应的Presenter并进行绑定
        protected MainPresenter bindPresenter() {
            return new MainPresenter(this);
        }
}
```

Presenter 是用于负责获取数据和业务逻辑。
```java
   public class MainPresenter extends BasePresenter<MainContact.IMain> implements MainContact.IMainPre {
   
       public MainPresenter(MainContact.IMain view) {
           super(view);
       }
   
   
       @Override
       public void getTel() {
           //省去网络请求代码
           //调用getView展示电话号码
          getView().showTel(result.getData());
       }
}
```
### HttpUtils 组件【拟定包含】
### HttpUtils 的使用【待补充】
### TimeUtils 组件
### TimeUtils 的使用【待补充】

