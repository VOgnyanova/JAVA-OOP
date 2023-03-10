package BorderControl;

public abstract class IdentifiableImpl implements Identifiable {

    private String id;

    protected IdentifiableImpl() {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

}
