package demo_20201028;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<OriginObject> {

	@Override
	public OriginObject getObject() throws Exception {
		OriginObject originObject = new OriginObject();
		return originObject;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return OriginObject.class;
	}

}
