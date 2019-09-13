
package aiss.model.amadeus;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CLJ",
    "RIX",
    "KTM",
    "KRK",
    "HNL",
    "MLE",
    "FLL",
    "ORL",
    "SLC",
    "WAW",
    "MTY",
    "PTY",
    "TLL",
    "GOA",
    "DBV",
    "MUC",
    "OSA",
    "PSA",
    "SSA",
    "ACC",
    "MDZ",
    "LWO",
    "MGA",
    "BOS",
    "LON",
    "TYO",
    "DEN",
    "TUN",
    "GOT",
    "SEA",
    "MAD",
    "CCS",
    "VIE",
    "MOW",
    "RGN",
    "ALC",
    "KIV",
    "VCE",
    "REK",
    "SIN",
    "GLA"
})
public class Locations {

    @JsonProperty("CLJ")
    private CLJ cLJ;
    @JsonProperty("RIX")
    private RIX rIX;
    @JsonProperty("KTM")
    private KTM kTM;
    @JsonProperty("KRK")
    private KRK kRK;
    @JsonProperty("HNL")
    private HNL hNL;
    @JsonProperty("MLE")
    private MLE mLE;
    @JsonProperty("FLL")
    private FLL fLL;
    @JsonProperty("ORL")
    private ORL oRL;
    @JsonProperty("SLC")
    private SLC sLC;
    @JsonProperty("WAW")
    private WAW wAW;
    @JsonProperty("MTY")
    private MTY mTY;
    @JsonProperty("PTY")
    private PTY pTY;
    @JsonProperty("TLL")
    private TLL tLL;
    @JsonProperty("GOA")
    private GOA gOA;
    @JsonProperty("DBV")
    private DBV dBV;
    @JsonProperty("MUC")
    private MUC mUC;
    @JsonProperty("OSA")
    private OSA oSA;
    @JsonProperty("PSA")
    private PSA pSA;
    @JsonProperty("SSA")
    private SSA sSA;
    @JsonProperty("ACC")
    private ACC aCC;
    @JsonProperty("MDZ")
    private MDZ mDZ;
    @JsonProperty("LWO")
    private LWO lWO;
    @JsonProperty("MGA")
    private MGA mGA;
    @JsonProperty("BOS")
    private BOS bOS;
    @JsonProperty("LON")
    private LON lON;
    @JsonProperty("TYO")
    private TYO tYO;
    @JsonProperty("DEN")
    private DEN dEN;
    @JsonProperty("TUN")
    private TUN tUN;
    @JsonProperty("GOT")
    private GOT gOT;
    @JsonProperty("SEA")
    private SEA sEA;
    @JsonProperty("MAD")
    private MAD mAD;
    @JsonProperty("CCS")
    private CCS cCS;
    @JsonProperty("VIE")
    private VIE vIE;
    @JsonProperty("MOW")
    private MOW mOW;
    @JsonProperty("RGN")
    private RGN rGN;
    @JsonProperty("ALC")
    private ALC aLC;
    @JsonProperty("KIV")
    private KIV kIV;
    @JsonProperty("VCE")
    private VCE vCE;
    @JsonProperty("REK")
    private REK rEK;
    @JsonProperty("SIN")
    private SIN sIN;
    @JsonProperty("GLA")
    private GLA gLA;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CLJ")
    public CLJ getCLJ() {
        return cLJ;
    }

    @JsonProperty("CLJ")
    public void setCLJ(CLJ cLJ) {
        this.cLJ = cLJ;
    }

    @JsonProperty("RIX")
    public RIX getRIX() {
        return rIX;
    }

    @JsonProperty("RIX")
    public void setRIX(RIX rIX) {
        this.rIX = rIX;
    }

    @JsonProperty("KTM")
    public KTM getKTM() {
        return kTM;
    }

    @JsonProperty("KTM")
    public void setKTM(KTM kTM) {
        this.kTM = kTM;
    }

    @JsonProperty("KRK")
    public KRK getKRK() {
        return kRK;
    }

    @JsonProperty("KRK")
    public void setKRK(KRK kRK) {
        this.kRK = kRK;
    }

    @JsonProperty("HNL")
    public HNL getHNL() {
        return hNL;
    }

    @JsonProperty("HNL")
    public void setHNL(HNL hNL) {
        this.hNL = hNL;
    }

    @JsonProperty("MLE")
    public MLE getMLE() {
        return mLE;
    }

    @JsonProperty("MLE")
    public void setMLE(MLE mLE) {
        this.mLE = mLE;
    }

    @JsonProperty("FLL")
    public FLL getFLL() {
        return fLL;
    }

    @JsonProperty("FLL")
    public void setFLL(FLL fLL) {
        this.fLL = fLL;
    }

    @JsonProperty("ORL")
    public ORL getORL() {
        return oRL;
    }

    @JsonProperty("ORL")
    public void setORL(ORL oRL) {
        this.oRL = oRL;
    }

    @JsonProperty("SLC")
    public SLC getSLC() {
        return sLC;
    }

    @JsonProperty("SLC")
    public void setSLC(SLC sLC) {
        this.sLC = sLC;
    }

    @JsonProperty("WAW")
    public WAW getWAW() {
        return wAW;
    }

    @JsonProperty("WAW")
    public void setWAW(WAW wAW) {
        this.wAW = wAW;
    }

    @JsonProperty("MTY")
    public MTY getMTY() {
        return mTY;
    }

    @JsonProperty("MTY")
    public void setMTY(MTY mTY) {
        this.mTY = mTY;
    }

    @JsonProperty("PTY")
    public PTY getPTY() {
        return pTY;
    }

    @JsonProperty("PTY")
    public void setPTY(PTY pTY) {
        this.pTY = pTY;
    }

    @JsonProperty("TLL")
    public TLL getTLL() {
        return tLL;
    }

    @JsonProperty("TLL")
    public void setTLL(TLL tLL) {
        this.tLL = tLL;
    }

    @JsonProperty("GOA")
    public GOA getGOA() {
        return gOA;
    }

    @JsonProperty("GOA")
    public void setGOA(GOA gOA) {
        this.gOA = gOA;
    }

    @JsonProperty("DBV")
    public DBV getDBV() {
        return dBV;
    }

    @JsonProperty("DBV")
    public void setDBV(DBV dBV) {
        this.dBV = dBV;
    }

    @JsonProperty("MUC")
    public MUC getMUC() {
        return mUC;
    }

    @JsonProperty("MUC")
    public void setMUC(MUC mUC) {
        this.mUC = mUC;
    }

    @JsonProperty("OSA")
    public OSA getOSA() {
        return oSA;
    }

    @JsonProperty("OSA")
    public void setOSA(OSA oSA) {
        this.oSA = oSA;
    }

    @JsonProperty("PSA")
    public PSA getPSA() {
        return pSA;
    }

    @JsonProperty("PSA")
    public void setPSA(PSA pSA) {
        this.pSA = pSA;
    }

    @JsonProperty("SSA")
    public SSA getSSA() {
        return sSA;
    }

    @JsonProperty("SSA")
    public void setSSA(SSA sSA) {
        this.sSA = sSA;
    }

    @JsonProperty("ACC")
    public ACC getACC() {
        return aCC;
    }

    @JsonProperty("ACC")
    public void setACC(ACC aCC) {
        this.aCC = aCC;
    }

    @JsonProperty("MDZ")
    public MDZ getMDZ() {
        return mDZ;
    }

    @JsonProperty("MDZ")
    public void setMDZ(MDZ mDZ) {
        this.mDZ = mDZ;
    }

    @JsonProperty("LWO")
    public LWO getLWO() {
        return lWO;
    }

    @JsonProperty("LWO")
    public void setLWO(LWO lWO) {
        this.lWO = lWO;
    }

    @JsonProperty("MGA")
    public MGA getMGA() {
        return mGA;
    }

    @JsonProperty("MGA")
    public void setMGA(MGA mGA) {
        this.mGA = mGA;
    }

    @JsonProperty("BOS")
    public BOS getBOS() {
        return bOS;
    }

    @JsonProperty("BOS")
    public void setBOS(BOS bOS) {
        this.bOS = bOS;
    }

    @JsonProperty("LON")
    public LON getLON() {
        return lON;
    }

    @JsonProperty("LON")
    public void setLON(LON lON) {
        this.lON = lON;
    }

    @JsonProperty("TYO")
    public TYO getTYO() {
        return tYO;
    }

    @JsonProperty("TYO")
    public void setTYO(TYO tYO) {
        this.tYO = tYO;
    }

    @JsonProperty("DEN")
    public DEN getDEN() {
        return dEN;
    }

    @JsonProperty("DEN")
    public void setDEN(DEN dEN) {
        this.dEN = dEN;
    }

    @JsonProperty("TUN")
    public TUN getTUN() {
        return tUN;
    }

    @JsonProperty("TUN")
    public void setTUN(TUN tUN) {
        this.tUN = tUN;
    }

    @JsonProperty("GOT")
    public GOT getGOT() {
        return gOT;
    }

    @JsonProperty("GOT")
    public void setGOT(GOT gOT) {
        this.gOT = gOT;
    }

    @JsonProperty("SEA")
    public SEA getSEA() {
        return sEA;
    }

    @JsonProperty("SEA")
    public void setSEA(SEA sEA) {
        this.sEA = sEA;
    }

    @JsonProperty("MAD")
    public MAD getMAD() {
        return mAD;
    }

    @JsonProperty("MAD")
    public void setMAD(MAD mAD) {
        this.mAD = mAD;
    }

    @JsonProperty("CCS")
    public CCS getCCS() {
        return cCS;
    }

    @JsonProperty("CCS")
    public void setCCS(CCS cCS) {
        this.cCS = cCS;
    }

    @JsonProperty("VIE")
    public VIE getVIE() {
        return vIE;
    }

    @JsonProperty("VIE")
    public void setVIE(VIE vIE) {
        this.vIE = vIE;
    }

    @JsonProperty("MOW")
    public MOW getMOW() {
        return mOW;
    }

    @JsonProperty("MOW")
    public void setMOW(MOW mOW) {
        this.mOW = mOW;
    }

    @JsonProperty("RGN")
    public RGN getRGN() {
        return rGN;
    }

    @JsonProperty("RGN")
    public void setRGN(RGN rGN) {
        this.rGN = rGN;
    }

    @JsonProperty("ALC")
    public ALC getALC() {
        return aLC;
    }

    @JsonProperty("ALC")
    public void setALC(ALC aLC) {
        this.aLC = aLC;
    }

    @JsonProperty("KIV")
    public KIV getKIV() {
        return kIV;
    }

    @JsonProperty("KIV")
    public void setKIV(KIV kIV) {
        this.kIV = kIV;
    }

    @JsonProperty("VCE")
    public VCE getVCE() {
        return vCE;
    }

    @JsonProperty("VCE")
    public void setVCE(VCE vCE) {
        this.vCE = vCE;
    }

    @JsonProperty("REK")
    public REK getREK() {
        return rEK;
    }

    @JsonProperty("REK")
    public void setREK(REK rEK) {
        this.rEK = rEK;
    }

    @JsonProperty("SIN")
    public SIN getSIN() {
        return sIN;
    }

    @JsonProperty("SIN")
    public void setSIN(SIN sIN) {
        this.sIN = sIN;
    }

    @JsonProperty("GLA")
    public GLA getGLA() {
        return gLA;
    }

    @JsonProperty("GLA")
    public void setGLA(GLA gLA) {
        this.gLA = gLA;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
