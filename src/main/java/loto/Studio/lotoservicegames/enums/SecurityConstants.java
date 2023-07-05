package loto.Studio.lotoservicegames.enums;

public class SecurityConstants {
	public static final String SECRET_KEY						= "7134743677397A24432646294A404E635266556A586E327235753878214125442A472D4B6150645367566B597033733676397924423F4528482B4D6251655468";
	public static final long EXPIRATION_TIME					= 36_000_000; // 1 hour
	public static final long EXPIRATION_HOUR					= 1_800_000; // 1/2 days
	public static final long TIME_DAY							= 86_400_000; // 1 days
	public static final String TOKEN_PREFIX						= "Bearer";
	public static final String HEADER_STRING					= "Authorization";
	public static final String TOKEN_ALGORITHME					= "HS512";
	
	public static final float IMG_QUALITY 						= 0.6f;
	
	public static final String EMAIL_PORT						= "587";
	public static final String EMAIL_PROTOCOL					= "smtp";
	public static final String EMAIL_ADDRESS					= "obank@bestfac.cm";
	public static final String EMAIL_SERVER						= "smtp.bestfac.cm";
	public static final String EMAIL_PASSWORD					= "AT7J?TXPkUG5";
	public static final String DOMAINE_CONF						= "https://secysoft.com";
	
	public static final String COMPTANT_NAME					= "comptant";
	public static final String COMPTANT_EMAIL					= "comptant@elixir.com";
	public static final String COMPTANT_PHONE					= "0000000";
	
	public static final String CODE_VENTE_PRODUIT				= "VT";
	public static final String CODE_APPROVISIONNEMENT_PRODUIT	= "AP";
	public static final String CODE_TRANSACTION_VENTE			= "TV";
	public static final String CODE_TRANSACTION_RECETTE			= "RC";
	public static final String CODE_TRANSACTION_DEPENSE			= "DP";
	
	public static final String BASE_NAME_MESSSAGE_BUNDLE		= "messages";

	public static final String LINK_API_CSU_HOPI				= "https://gateway.elixir.cm";


	public static final String SITE_NAME						= "Gaming Studio";
	public static final String SITE_LOCATION					= "https://loto-studio.cm";




}
