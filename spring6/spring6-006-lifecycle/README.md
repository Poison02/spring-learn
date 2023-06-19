Bean的生命周期五步：
  - 第一步：实例化Bean
  - 第二步：Bean属性赋值
  - 第三步：初始化Bean
  - 第四步：使用Bean
  - 第五步：销毁Bean

Bean生命周期七步：
  - 第一步：实例化Bean
  - 第二步：Bean属性赋值
  - **第三步：执行”Bean后处理器“的before方法**
  - 第四步：初始化Bean
  - **第五步：指定”Bean后处理器“的after方法**
  - 第六步：使用Bean
  - 第七步：销毁Bean

Bean生命周期十步：
  - 第一步：实例化Bean
  - 第二步：Bean属性赋值
  - **第三步：检查Bean是否实现了Aware相关接口，如果实现了则调用相关接口**
  - 第四步：执行”Bean后处理器“的before方法
  - **第五步：检查Bean是否实现了InitializingBean，如果实现了，调用相关方法**
  - 第六步：初始化Bean
  - 第七步：指定”Bean后处理器“的after方法
  - 第八步：使用Bean
  - **第九步：检查Bean是否实现了DisposableBean方法，如果实现了，调用相关方法**
  - 第十步：销毁Bean

十步中添加的三个步骤都是检查这个Bean是否实现了某些特定的接口，实现了这些接口，Spring就会调用某些特定的方法
