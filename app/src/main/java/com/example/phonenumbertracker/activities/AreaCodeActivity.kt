package com.example.phonenumbertracker.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.adapters.CustomAreaCodesAdapter
import com.example.phonenumbertracker.models.CustomAreaCodesItem
import com.hbb20.CountryCodePicker
import com.hbb20.CountryCodePicker.OnCountryChangeListener

class AreaCodeActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_areacodes)
        var toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(findViewById(R.id.toolbar))

        val textView: CountryCodePicker = findViewById(R.id.code) as CountryCodePicker

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))

        toolbar.setNavigationOnClickListener(View.OnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })


        val arrayListAfghanistan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPakistan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAland: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAlbania: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAlgeria: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAmerican_Samoa: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListZimbabwe: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListZambia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListYemen: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListWallis: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListVietnam: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListVenezuela: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAngola: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAnguilla: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListVanuatu: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAntarctica: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAntigua: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListUzbekistan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListUsVirginIsland: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListUruguay: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListUnitedStates: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListArgentina: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListArmenia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAruba: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListAustralia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListUnitedArabEmirates: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListUganda: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTuvalo: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTurks: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTurkmenistan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTurkey: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTunisia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTrinided: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTonga: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListTokelau: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBahamas: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBahrain: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBarbados: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBelarus: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBelize: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBenin: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBermuda: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBhutan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListBolvia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCambodia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCameroon: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCanada: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCapeVerde: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCayman: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCentralAfrican: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListChad: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListColombia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListComoros: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCongo: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCongoDemocratic: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListCookIslands: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCostaRica: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCoted: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCroatia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCuba: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListCuraco: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListDenmark: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListDjibouti: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListDominica: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListDominicaRepublic: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListEcuador: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListEqypt: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListelsalvador: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListEquatorialGuinea: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListEritrea: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListEstonia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListEthiopia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListFakland: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListFaroe: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListFiji: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListFinland: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListFrenchGuyana: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListFrenchPolynesia: ArrayList<CustomAreaCodesItem> =
            ArrayList<CustomAreaCodesItem>()
        val arrayListHaiti: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListHonduras: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListHongKong: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListHungary: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListIceland: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListIndia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListIran: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListIreland: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListIsrael: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListItaly: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListJamaica: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListJordan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListKazakhstan: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListKenya: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListKiribati: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListKosovo: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListKuwait: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLao: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLatvia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLebanon: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLesotho: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLiberia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLibya: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLiechtenstein: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLithuania: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListLuxembourg: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListOman: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPalau: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPalestine: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPanama: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPapua: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()

        val arrayListPeru: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPoland: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListPuertoRico: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()

        val arrayListQatar: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListReunion: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListRomania: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListRwanda: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()

        val arrayListSaintHelena: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListSaintKittsAndNevis: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListSaintLucia: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListSaintMartin: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()

        val arrayListSaintPierre: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListSaintVincent: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListSamoa: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()
        val arrayListSanMarino: ArrayList<CustomAreaCodesItem> = ArrayList<CustomAreaCodesItem>()




        val pakistan = resources.getStringArray(R.array.pakistan_city)
        val afghanistan = resources.getStringArray(R.array.afghanistan_city)
        val aland = resources.getStringArray(R.array.aland_city)
        val albania = resources.getStringArray(R.array.albania_city)
        val algeria = resources.getStringArray(R.array.algeria_city)
        val american_samoa = resources.getStringArray(R.array.american_samoa_city)
        val zimbabwe = resources.getStringArray(R.array.zimbabwe_city)
        val zambia = resources.getStringArray(R.array.zambia_city)
        val yemen = resources.getStringArray(R.array.yemen_city)
        val wallis = resources.getStringArray(R.array.walli_city)
        val vietnam = resources.getStringArray(R.array.vietnam_country)
        val venezuela = resources.getStringArray(R.array.venezuela_city)
        val angola = resources.getStringArray(R.array.Angola_city)
        val anguilla = resources.getStringArray(R.array.anguilla_city)
        val vanuatu = resources.getStringArray(R.array.vanuatu_city)
        val antarctica = resources.getStringArray(R.array.Antarctica_city)
        val antigua = resources.getStringArray(R.array.antigua_city)
        val uzbekistan = resources.getStringArray(R.array.uzbekistan_city)
        val usvirginislands = resources.getStringArray(R.array.us_virgin_islands_city)
        val uruguay = resources.getStringArray(R.array.uruguay_city)
        val unitedstates = resources.getStringArray(R.array.united_states_city)
        val argentina = resources.getStringArray(R.array.Argentina_city)
        val armenia = resources.getStringArray(R.array.Armenia_city)
        val aruba = resources.getStringArray(R.array.aruba_city)
        val australia = resources.getStringArray(R.array.Australia_city)
        val unitedarabemirates = resources.getStringArray(R.array.united_arab_emirates_city)
        val uganda = resources.getStringArray(R.array.uganda_city)
        val tuvalo = resources.getStringArray(R.array.tuvalo_city)
        val turks = resources.getStringArray(R.array.turks_city)
        val turkmenistan = resources.getStringArray(R.array.turkmenistan_city)
        val turkey = resources.getStringArray(R.array.turkey_city)
        val tunisia = resources.getStringArray(R.array.tunisia_city)
        val trinidad = resources.getStringArray(R.array.trinidad_city)
        val tonga = resources.getStringArray(R.array.tonga_city)
        val tokelau = resources.getStringArray(R.array.tokelau_city)
        val togo = resources.getStringArray(R.array.togo_city)
        val timer = resources.getStringArray(R.array.timor_city)
        val thailand = resources.getStringArray(R.array.thailand_city)
        val tanzania = resources.getStringArray(R.array.tanzania_city)
        val tajikistan = resources.getStringArray(R.array.tajikistan_city)
        val taiwan = resources.getStringArray(R.array.taiwan_city)
        val syrian = resources.getStringArray(R.array.syrian_city)
        val austria = resources.getStringArray(R.array.Austria_city)
        val bahamas = resources.getStringArray(R.array.bahamas_city)
        val bahrain = resources.getStringArray(R.array.bahrain_city)
        val barbados = resources.getStringArray(R.array.barbados_city)
        val belarus = resources.getStringArray(R.array.Belarus_city)
        val belize = resources.getStringArray(R.array.Belize_city)
        val benin = resources.getStringArray(R.array.Benin_city)
        val bermuda = resources.getStringArray(R.array.Bermuda_city)
        val bhutan = resources.getStringArray(R.array.Bhutan_city)
        val bolvia = resources.getStringArray(R.array.Bolivia_city)
        val cambodia = resources.getStringArray(R.array.Cambodia_city)
        val cameroon = resources.getStringArray(R.array.Cameroon_city)
        val canada = resources.getStringArray(R.array.Canada_city)
        val capeVerde = resources.getStringArray(R.array.CapeVerde_city)
        val cayman = resources.getStringArray(R.array.Cayman_city)
        val centralAfrican = resources.getStringArray(R.array.CentralAfrican_city)
        val chad = resources.getStringArray(R.array.Chad_city)
        val colombia = resources.getStringArray(R.array.Colombia_city)
        val comoros = resources.getStringArray(R.array.Comoros_city)
        val congo = resources.getStringArray(R.array.Congo_city)
        val congoDemocratic = resources.getStringArray(R.array.CongoDemocratic_city)
        val cookislands = resources.getStringArray(R.array.CookIslands_city)
        val costarica = resources.getStringArray(R.array.CostaRica_city)
        val coteD = resources.getStringArray(R.array.CotedIvoire_city)
        val croatia = resources.getStringArray(R.array.Croatia_city)
        val cuba = resources.getStringArray(R.array.Cuba_city)
        val curacao = resources.getStringArray(R.array.Curacao_city)
        val denamrk = resources.getStringArray(R.array.Denmark_city)
        val djibouti = resources.getStringArray(R.array.Djibouti_city)
        val dominica = resources.getStringArray(R.array.Dominica_city)
        val dominicarepublic = resources.getStringArray(R.array.DominicanRepublic_city)
        val ecuador = resources.getStringArray(R.array.Ecuador_city)
        val egypt = resources.getStringArray(R.array.Egypt_city)
        val elsalvador = resources.getStringArray(R.array.ElSalvador_city)
        val equatorial = resources.getStringArray(R.array.EquatorialGuinea_city)
        val eritrea = resources.getStringArray(R.array.Eritrea_city)
        val estonia = resources.getStringArray(R.array.Estonia_city)
        val ethiopia = resources.getStringArray(R.array.Ethiopia_city)
        val falkland = resources.getStringArray(R.array.FalklandIslands_city)
        val faroe = resources.getStringArray(R.array.FaroeIslands_city)
        val fiji = resources.getStringArray(R.array.Fiji_city)
        val finland = resources.getStringArray(R.array.Finland_city)
        val frenchguyana = resources.getStringArray(R.array.FrenchGuiana_city)
        val frenchpolynesia = resources.getStringArray(R.array.FrenchPolynesia_city)
        val haiti = resources.getStringArray(R.array.Haiti_city)
        val honduras = resources.getStringArray(R.array.Honduras_city)
        val hongkong = resources.getStringArray(R.array.HongKong_city)
        val hungary = resources.getStringArray(R.array.Hungary_city)
        val iceland = resources.getStringArray(R.array.Iceland_city)
        val india = resources.getStringArray(R.array.India_city)
        val iran = resources.getStringArray(R.array.Iran_city)
        val ireland = resources.getStringArray(R.array.Ireland_city)
        val israel = resources.getStringArray(R.array.Israel_city)
        val italy = resources.getStringArray(R.array.Italy_city)
        val kazakhstan = resources.getStringArray(R.array.Kazakhstan_city)
        val kenya = resources.getStringArray(R.array.Kenya_city)
        val kiribati = resources.getStringArray(R.array.Kiribati_city)
        val kosovo = resources.getStringArray(R.array.Kosovo_city)
        val kuwait = resources.getStringArray(R.array.Kuwait_city)
        val jamaica = resources.getStringArray(R.array.Jamaica_city)
        val jordan = resources.getStringArray(R.array.Jordan_city)
        val lao = resources.getStringArray(R.array.Laos_city)
        val latvia = resources.getStringArray(R.array.Latvia_city)
        val lebanon = resources.getStringArray(R.array.Lebanon_city)
        val lesotho = resources.getStringArray(R.array.Lesotho_city)
        val liberia = resources.getStringArray(R.array.Liberia_city)
        val libya = resources.getStringArray(R.array.Libya_city)
        val liechtenstein = resources.getStringArray(R.array.Liechtenstein_city)
        val lithuania = resources.getStringArray(R.array.Lithuania_city)
        val luxembourg = resources.getStringArray(R.array.Luxembourg_city)
        val oman = resources.getStringArray(R.array.Oman_city)

        val palau = resources.getStringArray(R.array.Palau_city)
        val palestine = resources.getStringArray(R.array.Palestine_city)
        val panama = resources.getStringArray(R.array.Panama_city)
        val papua = resources.getStringArray(R.array.PapuaNewGuinea_city)

        val peru = resources.getStringArray(R.array.Peru_city)
        val poland = resources.getStringArray(R.array.Poland_city)
        val puertoRico = resources.getStringArray(R.array.PuertoRico_city)

        val qatar = resources.getStringArray(R.array.Qatar_city)
        val reunion = resources.getStringArray(R.array.Reunion_city)
        val romania = resources.getStringArray(R.array.Romania_city)
        val rwanda = resources.getStringArray(R.array.Rwanda_city)

        val saintlenena = resources.getStringArray(R.array.SaintHelena_city)
        val saintkittsandnevis = resources.getStringArray(R.array.SaintKittsandNevis_city)
        val saintlucia = resources.getStringArray(R.array.SaintLucia_city)
        val saintmartin = resources.getStringArray(R.array.SaintMartin_city)

        val saintpierre = resources.getStringArray(R.array.SaintPierraAndMiquelon_city)
        val saintvincent = resources.getStringArray(R.array.SaintVincentandtheGrenadines_city)
        val samoa = resources.getStringArray(R.array.Samoa_city)
        val sanmarino = resources.getStringArray(R.array.SanMarino_city)


        var i = 0
        for (value in pakistan) {
            val pakistan_city = resources.getStringArray(R.array.pakistan_city)[i]
            val pakistan_code = resources.getStringArray(R.array.pakistan_code)[i]
            i++
            arrayListPakistan.add(CustomAreaCodesItem(pakistan_city, pakistan_code))
        }
        callAdapter(arrayListPakistan)

        textView.setOnCountryChangeListener(OnCountryChangeListener {
            var i = 0//Al
            // ert.showMessage(RegistrationActivity.this, ccp.getSelectedCountryCodeWithPlus());
            val selected_country_code = textView.selectedCountryName
            val selected_country = textView.selectedCountryCode
            //Toast.makeText(this, selected_country_code, Toast.LENGTH_SHORT).show()
            if (selected_country_code.equals("Afghanistan")) {
                if (arrayListAfghanistan.isNullOrEmpty()) {
                    for (value in afghanistan) {
                        val afghanistan_city = resources.getStringArray(R.array.afghanistan_city)[i]
                        val afghanistan_code = resources.getStringArray(R.array.afghanistan_code)[i]
                        i++
                        arrayListAfghanistan.add(
                            CustomAreaCodesItem(
                                afghanistan_city,
                                afghanistan_code
                            )
                        )
                        Log.e("countryData", arrayListAfghanistan.toString())
                    }
                }
                callAdapter(arrayListAfghanistan)

            } else if (selected_country_code.equals("Pakistan")) {
                if (arrayListPakistan.isNullOrEmpty()) {
                    for (value in pakistan) {
                        val pakistan_city = resources.getStringArray(R.array.pakistan_city)[i]
                        val pakistan_code = resources.getStringArray(R.array.pakistan_code)[i]
                        i++
                        arrayListPakistan.add(CustomAreaCodesItem(pakistan_city, pakistan_code))
                    }
                }
                callAdapter(arrayListPakistan)

            } else if (selected_country_code.equals("AlandIslands")) {
                if (arrayListAland.isNullOrEmpty()) {
                    for (value in aland) {
                        val aland_city = resources.getStringArray(R.array.aland_city)[i]
                        val aland_code = resources.getStringArray(R.array.aland_code)[i]
                        i++
                        arrayListAland.add(CustomAreaCodesItem(aland_city, aland_code))
                    }
                }
                callAdapter(arrayListAland)

            } else if (selected_country_code.equals("Albania")) {
                if (arrayListAlbania.isNullOrEmpty()) {
                    for (value in albania) {
                        val albania_city = resources.getStringArray(R.array.albania_city)[i]
                        val albania_code = resources.getStringArray(R.array.albania_code)[i]
                        i++
                        arrayListAlbania.add(CustomAreaCodesItem(albania_city, albania_code))
                        Log.e("countryData", arrayListAlbania.toString())
                    }
                }
                callAdapter(arrayListAlbania)

            } else if (selected_country_code.equals("Algeria")) {
                if (arrayListAlgeria.isNullOrEmpty()) {
                    for (value in algeria) {
                        val algeria_city = resources.getStringArray(R.array.algeria_city)[i]
                        val algeria_code = resources.getStringArray(R.array.algeria_code)[i]
                        i++
                        arrayListAlgeria.add(CustomAreaCodesItem(algeria_city, algeria_code))
                        Log.e("countryData", arrayListAlgeria.toString())
                    }
                }
                callAdapter(arrayListAlgeria)

            } else if (selected_country_code.equals("American Samoa")) {
                if (arrayListAmerican_Samoa.isNullOrEmpty()) {
                    for (value in american_samoa) {
                        val american_city = resources.getStringArray(R.array.american_samoa_city)[i]
                        val american_code = resources.getStringArray(R.array.american_samoa_code)[i]
                        i++
                        arrayListAmerican_Samoa.add(
                            CustomAreaCodesItem(
                                american_city,
                                american_code
                            )
                        )
                        Log.e("countryData", arrayListAmerican_Samoa.toString())
                    }
                }
                callAdapter(arrayListAmerican_Samoa)

            } else if (selected_country_code.equals("Zimbabwe")) {
                if (arrayListZimbabwe.isNullOrEmpty()) {
                    for (value in zimbabwe) {
                        val zimbabwe_city = resources.getStringArray(R.array.zimbabwe_city)[i]
                        val zimbabwe_code = resources.getStringArray(R.array.zimbabwe_code)[i]
                        i++
                        arrayListZimbabwe.add(CustomAreaCodesItem(zimbabwe_city, zimbabwe_code))
                        Log.e("countryData", arrayListZimbabwe.toString())
                    }
                }
                callAdapter(arrayListZimbabwe)

            } else if (selected_country_code.equals("Zambia")) {
                if (arrayListZambia.isNullOrEmpty()) {
                    for (value in zambia) {
                        val zambia_city = resources.getStringArray(R.array.zambia_city)[i]
                        val zambia_code = resources.getStringArray(R.array.zambia_code)[i]
                        i++
                        arrayListZambia.add(CustomAreaCodesItem(zambia_city, zambia_code))
                        Log.e("countryData", arrayListZambia.toString())
                    }
                }
                callAdapter(arrayListZambia)
            } else if (selected_country_code.equals("Yemen")) {
                if (arrayListYemen.isNullOrEmpty()) {
                    for (value in yemen) {
                        val yemen_city = resources.getStringArray(R.array.yemen_city)[i]
                        val yemen_code = resources.getStringArray(R.array.yemen_code)[i]
                        i++
                        arrayListYemen.add(CustomAreaCodesItem(yemen_city, yemen_code))
                        Log.e("countryData", arrayListYemen.toString())
                    }
                }
                callAdapter(arrayListYemen)
            } else if (selected_country_code.equals("Wallis And Futuna")) {
                if (arrayListWallis.isNullOrEmpty()) {
                    for (value in wallis) {
                        val wallis_city = resources.getStringArray(R.array.walli_city)[i]
                        val wallis_code = resources.getStringArray(R.array.wallis_code)[i]
                        i++
                        arrayListWallis.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListWallis)
            } else if (selected_country_code.equals("Vietnam")) {
                if (arrayListVietnam.isNullOrEmpty()) {
                    for (value in vietnam) {
                        val wallis_city = resources.getStringArray(R.array.vietnam_country)[i]
                        val wallis_code = resources.getStringArray(R.array.vietnam_code)[i]
                        i++
                        arrayListVietnam.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListVietnam)
            } else if (selected_country_code.equals("Venezuela, Bolivarian Republic Of")) {
                if (arrayListVenezuela.isNullOrEmpty()) {
                    for (value in venezuela) {
                        val wallis_city = resources.getStringArray(R.array.venezuela_city)[i]
                        val wallis_code = resources.getStringArray(R.array.venezuela_code)[i]
                        i++
                        arrayListVenezuela.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListVenezuela)
            } else if (selected_country_code.equals("Angola")) {
                if (arrayListAngola.isNullOrEmpty()) {
                    for (value in angola) {
                        val wallis_city = resources.getStringArray(R.array.Angola_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Angola_code)[i]
                        i++
                        arrayListAngola.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListAngola)
            } else if (selected_country_code.equals("Anguilla")) {
                if (arrayListAnguilla.isNullOrEmpty()) {
                    for (value in anguilla) {
                        val wallis_city = resources.getStringArray(R.array.anguilla_city)[i]
                        val wallis_code = resources.getStringArray(R.array.anguilla_code)[i]
                        i++
                        arrayListAnguilla.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListAnguilla)
            } else if (selected_country_code.equals("Vanuatu")) {
                if (arrayListVanuatu.isNullOrEmpty()) {
                    for (value in vanuatu) {
                        val wallis_city = resources.getStringArray(R.array.vanuatu_city)[i]
                        val wallis_code = resources.getStringArray(R.array.vanuatu_code)[i]
                        i++
                        arrayListVanuatu.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListVanuatu)
            } else if (selected_country_code.equals("Antarctica")) {
                if (arrayListAntarctica.isNullOrEmpty()) {
                    for (value in antarctica) {
                        val wallis_city = resources.getStringArray(R.array.Antarctica_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Antarctica_code)[i]
                        i++
                        arrayListAntarctica.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListAntarctica)
            } else if (selected_country_code.equals("Antigua and Barbuda")) {
                if (arrayListAntigua.isNullOrEmpty()) {
                    for (value in antigua) {
                        val wallis_city = resources.getStringArray(R.array.antigua_city)[i]
                        val wallis_code = resources.getStringArray(R.array.antigua_code)[i]
                        i++
                        arrayListAntigua.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListAntigua)
            } else if (selected_country_code.equals("Uzbekistan")) {
                if (arrayListUzbekistan.isNullOrEmpty()) {
                    for (value in uzbekistan) {
                        val wallis_city = resources.getStringArray(R.array.uzbekistan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.uzbekistan_code)[i]
                        i++
                        arrayListUzbekistan.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListUzbekistan)
            } else if (selected_country_code.equals("US Virgin Islands")) {
                if (arrayListUsVirginIsland.isNullOrEmpty()) {
                    for (value in usvirginislands) {
                        val wallis_city =
                            resources.getStringArray(R.array.us_virgin_islands_city)[i]
                        val wallis_code =
                            resources.getStringArray(R.array.us_virgin_islands_code)[i]
                        i++
                        arrayListUsVirginIsland.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListUsVirginIsland)
            } else if (selected_country_code.equals("Uruguay")) {
                if (arrayListUruguay.isNullOrEmpty()) {
                    for (value in uruguay) {
                        val wallis_city = resources.getStringArray(R.array.uruguay_city)[i]
                        val wallis_code = resources.getStringArray(R.array.uruguay_code)[i]
                        i++
                        arrayListUruguay.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListUruguay)
            } else if (selected_country_code.equals("United States")) {
                if (arrayListUnitedStates.isNullOrEmpty()) {
                    for (value in unitedstates) {
                        val wallis_city = resources.getStringArray(R.array.united_states_city)[i]
                        val wallis_code = resources.getStringArray(R.array.united_states_code)[i]
                        i++
                        arrayListUnitedStates.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListUnitedStates)
            } else if (selected_country_code.equals("Argentina")) {
                if (arrayListArgentina.isNullOrEmpty()) {
                    for (value in argentina) {
                        val wallis_city = resources.getStringArray(R.array.Argentina_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Argentina_code)[i]
                        i++
                        arrayListArgentina.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListArgentina)
            } else if (selected_country_code.equals("Armenia")) {
                if (arrayListArmenia.isNullOrEmpty()) {
                    for (value in armenia) {
                        val wallis_city = resources.getStringArray(R.array.Armenia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Armenia_code)[i]
                        i++
                        arrayListArmenia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListArmenia)
            } else if (selected_country_code.equals("Aruba")) {
                if (arrayListAruba.isNullOrEmpty()) {
                    for (value in aruba) {
                        val wallis_city = resources.getStringArray(R.array.aruba_city)[i]
                        val wallis_code = resources.getStringArray(R.array.aruba_code)[i]
                        i++
                        arrayListAruba.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListAruba)
            } else if (selected_country_code.equals("Australia")) {
                if (arrayListAustralia.isNullOrEmpty()) {
                    for (value in australia) {
                        val wallis_city = resources.getStringArray(R.array.Australia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Australia_code)[i]
                        i++
                        arrayListAustralia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListAustralia)
            } else if (selected_country == "971") {
                if (arrayListUnitedArabEmirates.isNullOrEmpty()) {
                    for (value in unitedarabemirates) {
                        val wallis_city =
                            resources.getStringArray(R.array.united_arab_emirates_city)[i]
                        val wallis_code =
                            resources.getStringArray(R.array.united_arab_emirates_code)[i]
                        i++
                        arrayListUnitedArabEmirates.add(
                            CustomAreaCodesItem(
                                wallis_city,
                                wallis_code
                            )
                        )
                    }
                }
                callAdapter(arrayListUnitedArabEmirates)
            } else if (selected_country_code.equals("Uganda")) {
                if (arrayListUganda.isNullOrEmpty()) {
                    for (value in uganda) {
                        val wallis_city = resources.getStringArray(R.array.uganda_city)[i]
                        val wallis_code = resources.getStringArray(R.array.uganda_code)[i]
                        i++
                        arrayListUganda.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListUganda)
            } else if (selected_country == "688") {
                if (arrayListTuvalo.isNullOrEmpty()) {
                    for (value in tuvalo) {
                        val wallis_city = resources.getStringArray(R.array.tuvalo_city)[i]
                        val wallis_code = resources.getStringArray(R.array.tuvalo_code)[i]
                        i++
                        arrayListTuvalo.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTuvalo)
            } else if (selected_country_code.equals("Turks and Caicos Islands")) {
                if (arrayListTurks.isNullOrEmpty()) {
                    for (value in turks) {
                        val wallis_city = resources.getStringArray(R.array.turks_city)[i]
                        val wallis_code = resources.getStringArray(R.array.turks_code)[i]
                        i++
                        arrayListTurks.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurks)
            } else if (selected_country_code.equals("Turkmenistan")) {
                if (arrayListTurkmenistan.isNullOrEmpty()) {
                    for (value in turkmenistan) {
                        val wallis_city = resources.getStringArray(R.array.turkmenistan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.turkmenistan_code)[i]
                        i++
                        arrayListTurkmenistan.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkmenistan)
            } else if (selected_country_code.equals("Turkey")) {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in turkey) {
                        val wallis_city = resources.getStringArray(R.array.turkey_city)[i]
                        val wallis_code = resources.getStringArray(R.array.turkey_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country_code.equals("Tunisia")) {
                if (arrayListTunisia.isNullOrEmpty()) {
                    for (value in tunisia) {
                        val wallis_city = resources.getStringArray(R.array.tunisia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.tunisia_code)[i]
                        i++
                        arrayListTunisia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTunisia)
            } else if (selected_country_code.equals("Trinidad & Tobago")) {
                if (arrayListTrinided.isNullOrEmpty()) {
                    for (value in trinidad) {
                        val wallis_city = resources.getStringArray(R.array.trinidad_city)[i]
                        val wallis_code = resources.getStringArray(R.array.trinidad_code)[i]
                        i++
                        arrayListTrinided.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTrinided)
            } else if (selected_country_code.equals("Tonga")) {
                if (arrayListTonga.isNullOrEmpty()) {
                    for (value in tonga) {
                        val wallis_city = resources.getStringArray(R.array.tonga_city)[i]
                        val wallis_code = resources.getStringArray(R.array.tonga_code)[i]
                        i++
                        arrayListTonga.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTonga)
            } else if (selected_country_code.equals("Tokelau")) {
                if (arrayListTokelau.isNullOrEmpty()) {
                    for (value in tokelau) {
                        val wallis_city = resources.getStringArray(R.array.tokelau_city)[i]
                        val wallis_code = resources.getStringArray(R.array.tokelau_code)[i]
                        i++
                        arrayListTokelau.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTokelau)
            } else if (selected_country_code.equals("Togo")) {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in togo) {
                        val wallis_city = resources.getStringArray(R.array.togo_city)[i]
                        val wallis_code = resources.getStringArray(R.array.togo_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country == "670") {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in timer) {
                        val wallis_city = resources.getStringArray(R.array.timor_city)[i]
                        val wallis_code = resources.getStringArray(R.array.timor_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country_code.equals("Thailand")) {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in thailand) {
                        val wallis_city = resources.getStringArray(R.array.thailand_city)[i]
                        val wallis_code = resources.getStringArray(R.array.thailand_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country == "255") {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in tanzania) {
                        val wallis_city = resources.getStringArray(R.array.tanzania_city)[i]
                        val wallis_code = resources.getStringArray(R.array.tanzania_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country_code.equals("Tajikistan")) {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in tajikistan) {
                        val wallis_city = resources.getStringArray(R.array.tajikistan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.tajikistan_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country_code.equals("Taiwan")) {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in taiwan) {
                        val wallis_city = resources.getStringArray(R.array.taiwan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.taiwan_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country == "963") {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in syrian) {
                        val wallis_city = resources.getStringArray(R.array.syrian_city)[i]
                        val wallis_code = resources.getStringArray(R.array.syrian_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country_code.equals("Austria")) {
                if (arrayListTurkey.isNullOrEmpty()) {
                    for (value in austria) {
                        val wallis_city = resources.getStringArray(R.array.Austria_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Austria_code)[i]
                        i++
                        arrayListTurkey.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListTurkey)
            } else if (selected_country_code.equals("Bahamas")) {
                if (arrayListBahamas.isNullOrEmpty()) {
                    for (value in bahamas) {
                        val wallis_city = resources.getStringArray(R.array.bahamas_city)[i]
                        val wallis_code = resources.getStringArray(R.array.bahamas_code)[i]
                        i++
                        arrayListBahamas.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBahamas)
            } else if (selected_country_code.equals("Bahrain")) {
                if (arrayListBahrain.isNullOrEmpty()) {
                    for (value in bahrain) {
                        val wallis_city = resources.getStringArray(R.array.bahrain_city)[i]
                        val wallis_code = resources.getStringArray(R.array.bahrain_code)[i]
                        i++
                        arrayListBahrain.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBahrain)
            } else if (selected_country_code.equals("Barbados")) {
                if (arrayListBarbados.isNullOrEmpty()) {
                    for (value in barbados) {
                        val wallis_city = resources.getStringArray(R.array.barbados_city)[i]
                        val wallis_code = resources.getStringArray(R.array.barbados_code)[i]
                        i++
                        arrayListBarbados.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBarbados)
            } else if (selected_country_code.equals("Belarus")) {
                if (arrayListBelarus.isNullOrEmpty()) {
                    for (value in belarus) {
                        val wallis_city = resources.getStringArray(R.array.Belarus_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Belarus_code)[i]
                        i++
                        arrayListBelarus.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBelarus)
            } else if (selected_country_code.equals("Belize")) {
                if (arrayListBelize.isNullOrEmpty()) {
                    for (value in belize) {
                        val wallis_city = resources.getStringArray(R.array.Belize_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Belize_code)[i]
                        i++
                        arrayListBelize.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBelize)
            } else if (selected_country_code.equals("Benin")) {
                if (arrayListBenin.isNullOrEmpty()) {
                    for (value in benin) {
                        val wallis_city = resources.getStringArray(R.array.Benin_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Benin_code)[i]
                        i++
                        arrayListBenin.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBenin)
            } else if (selected_country_code.equals("Bermuda")) {
                if (arrayListBermuda.isNullOrEmpty()) {
                    for (value in bermuda) {
                        val wallis_city = resources.getStringArray(R.array.Bermuda_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Bermuda_code)[i]
                        i++
                        arrayListBermuda.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBermuda)
            } else if (selected_country_code.equals("Bhutan")) {
                if (arrayListBhutan.isNullOrEmpty()) {
                    for (value in bhutan) {
                        val wallis_city = resources.getStringArray(R.array.Bhutan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Bhutan_code)[i]
                        i++
                        arrayListBhutan.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBhutan)
            } else if (selected_country_code.equals("Bolvia")) {
                if (arrayListBolvia.isNullOrEmpty()) {
                    for (value in bolvia) {
                        val wallis_city = resources.getStringArray(R.array.Bolivia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Bolivia_code)[i]
                        i++
                        arrayListBolvia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListBolvia)
            } else if (selected_country_code.equals("Cambodia")) {
                if (arrayListCambodia.isNullOrEmpty()) {
                    for (value in cambodia) {
                        val wallis_city = resources.getStringArray(R.array.Cambodia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Cambodia_code)[i]
                        i++
                        arrayListCambodia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCambodia)
            } else if (selected_country_code.equals("Cameroon")) {
                if (arrayListCameroon.isNullOrEmpty()) {
                    for (value in cameroon) {
                        val wallis_city = resources.getStringArray(R.array.Cameroon_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Cameroon_code)[i]
                        i++
                        arrayListCameroon.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCameroon)
            } else if (selected_country_code.equals("Canada")) {
                if (arrayListCanada.isNullOrEmpty()) {
                    for (value in canada) {
                        val wallis_city = resources.getStringArray(R.array.Canada_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Canada_code)[i]
                        i++
                        arrayListCanada.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCanada)
            } else if (selected_country_code.equals("Cape Verde")) {
                if (arrayListCapeVerde.isNullOrEmpty()) {
                    for (value in capeVerde) {
                        val wallis_city = resources.getStringArray(R.array.CapeVerde_city)[i]
                        val wallis_code = resources.getStringArray(R.array.CapeVerde_code)[i]
                        i++
                        arrayListCapeVerde.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCapeVerde)
            } else if (selected_country_code.equals("Cayman Islands")) {
                if (arrayListCayman.isNullOrEmpty()) {
                    for (value in cayman) {
                        val wallis_city = resources.getStringArray(R.array.Cayman_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Cayman_code)[i]
                        i++
                        arrayListCayman.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCayman)
            } else if (selected_country_code.equals("Central African Republic")) {
                if (arrayListCentralAfrican.isNullOrEmpty()) {
                    for (value in centralAfrican) {
                        val wallis_city = resources.getStringArray(R.array.CentralAfrican_city)[i]
                        val wallis_code = resources.getStringArray(R.array.CentralAfrican_code)[i]
                        i++
                        arrayListCentralAfrican.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCentralAfrican)
            } else if (selected_country_code.equals("Chad")) {
                if (arrayListChad.isNullOrEmpty()) {
                    for (value in chad) {
                        val wallis_city = resources.getStringArray(R.array.Chad_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Chad_code)[i]
                        i++
                        arrayListChad.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListChad)
            } else if (selected_country_code.equals("Colombia")) {
                if (arrayListColombia.isNullOrEmpty()) {
                    for (value in colombia) {
                        val wallis_city = resources.getStringArray(R.array.Colombia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Colombia_code)[i]
                        i++
                        arrayListColombia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListColombia)
            } else if (selected_country_code.equals("Comoros")) {
                if (arrayListComoros.isNullOrEmpty()) {
                    for (value in comoros) {
                        val wallis_city = resources.getStringArray(R.array.Comoros_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Comoros_code)[i]
                        i++
                        arrayListComoros.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListComoros)
            } else if (selected_country_code.equals("Congo")) {
                if (arrayListCongo.isNullOrEmpty()) {
                    for (value in congo) {
                        val wallis_city = resources.getStringArray(R.array.Congo_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Congo_code)[i]
                        i++
                        arrayListCongo.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCongo)
            } else if (selected_country_code.equals("Congo, The Democratic Republic Of The")) {
                if (arrayListCongoDemocratic.isNullOrEmpty()) {
                    for (value in congoDemocratic) {
                        val wallis_city = resources.getStringArray(R.array.CongoDemocratic_city)[i]
                        val wallis_code = resources.getStringArray(R.array.CongoDemocratic_code)[i]
                        i++
                        arrayListCongoDemocratic.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCongoDemocratic)
            } else if (selected_country_code.equals("Cook Islands")) {
                if (arrayListCongoDemocratic.isNullOrEmpty()) {
                    for (value in cookislands) {
                        val wallis_city = resources.getStringArray(R.array.CookIslands_city)[i]
                        val wallis_code = resources.getStringArray(R.array.CookIslands_code)[i]
                        i++
                        arrayListCookIslands.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCookIslands)
            } else if (selected_country_code.equals("Costa Rica")) {
                if (arrayListCostaRica.isNullOrEmpty()) {
                    for (value in costarica) {
                        val wallis_city = resources.getStringArray(R.array.CostaRica_city)[i]
                        val wallis_code = resources.getStringArray(R.array.CostaRica_code)[i]
                        i++
                        arrayListCostaRica.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCostaRica)
            } else if (selected_country == "225") {
                if (arrayListCoted.isNullOrEmpty()) {
                    for (value in coteD) {
                        val wallis_city = resources.getStringArray(R.array.CotedIvoire_city)[i]
                        val wallis_code = resources.getStringArray(R.array.CotedIvoire_code)[i]
                        i++
                        arrayListCoted.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCoted)
            } else if (selected_country_code.equals("Croatia")) {
                if (arrayListCoted.isNullOrEmpty()) {
                    for (value in croatia) {
                        val wallis_city = resources.getStringArray(R.array.Croatia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Croatia_code)[i]
                        i++
                        arrayListCroatia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCroatia)
            } else if (selected_country_code.equals("Cuba")) {
                if (arrayListCuba.isNullOrEmpty()) {
                    for (value in cuba) {
                        val wallis_city = resources.getStringArray(R.array.Cuba_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Cuba_code)[i]
                        i++
                        arrayListCuba.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCuba)
            } else if (selected_country == "599") {
                if (arrayListCuraco.isNullOrEmpty()) {
                    for (value in curacao) {
                        val wallis_city = resources.getStringArray(R.array.Curacao_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Curacao_code)[i]
                        i++
                        arrayListCuraco.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListCuraco)
            } else if (selected_country_code.equals("Denmark")) {
                if (arrayListDenmark.isNullOrEmpty()) {
                    for (value in denamrk) {
                        val wallis_city = resources.getStringArray(R.array.Denmark_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Denmark_code)[i]
                        i++
                        arrayListDenmark.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListDenmark)
            } else if (selected_country_code.equals("Djibouti")) {
                if (arrayListDjibouti.isNullOrEmpty()) {
                    for (value in djibouti) {
                        val wallis_city = resources.getStringArray(R.array.Djibouti_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Djibouti_code)[i]
                        i++
                        arrayListDjibouti.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListDjibouti)
            } else if (selected_country_code.equals("Dominica")) {
                if (arrayListDominica.isNullOrEmpty()) {
                    for (value in dominica) {
                        val wallis_city = resources.getStringArray(R.array.Dominica_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Dominica_code)[i]
                        i++
                        arrayListDominica.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListDominica)
            } else if (selected_country == "1") {
                if (arrayListDominicaRepublic.isNullOrEmpty()) {
                    for (value in dominicarepublic) {
                        val wallis_city =
                            resources.getStringArray(R.array.DominicanRepublic_city)[i]
                        val wallis_code =
                            resources.getStringArray(R.array.DominicanRepublic_code)[i]
                        i++
                        arrayListDominicaRepublic.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListDominicaRepublic)
            } else if (selected_country_code.equals("Ecuador")) {
                if (arrayListEcuador.isNullOrEmpty()) {
                    for (value in ecuador) {
                        val wallis_city = resources.getStringArray(R.array.Ecuador_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Ecuador_code)[i]
                        i++
                        arrayListEcuador.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListEcuador)
            } else if (selected_country_code.equals("Egypt")) {
                if (arrayListEqypt.isNullOrEmpty()) {
                    for (value in egypt) {
                        val wallis_city = resources.getStringArray(R.array.Egypt_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Egypt_code)[i]
                        i++
                        arrayListEqypt.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListEqypt)
            } else if (selected_country_code.equals("El Salvador")) {
                if (arrayListelsalvador.isNullOrEmpty()) {
                    for (value in elsalvador) {
                        val wallis_city = resources.getStringArray(R.array.ElSalvador_city)[i]
                        val wallis_code = resources.getStringArray(R.array.ElSalvador_code)[i]
                        i++
                        arrayListelsalvador.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListelsalvador)
            } else if (selected_country_code.equals("Equatorial Guinea")) {
                if (arrayListEquatorialGuinea.isNullOrEmpty()) {
                    for (value in equatorial) {
                        val wallis_city = resources.getStringArray(R.array.EquatorialGuinea_city)[i]
                        val wallis_code = resources.getStringArray(R.array.EquatorialGuinea_code)[i]
                        i++
                        arrayListEquatorialGuinea.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListEquatorialGuinea)
            } else if (selected_country_code.equals("Eritrea")) {
                if (arrayListEritrea.isNullOrEmpty()) {
                    for (value in eritrea) {
                        val wallis_city = resources.getStringArray(R.array.Eritrea_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Eritrea_code)[i]
                        i++
                        arrayListEritrea.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListEritrea)
            } else if (selected_country_code.equals("Estonia")) {
                if (arrayListEstonia.isNullOrEmpty()) {
                    for (value in estonia) {
                        val wallis_city = resources.getStringArray(R.array.Estonia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Estonia_code)[i]
                        i++
                        arrayListEstonia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListEstonia)
            } else if (selected_country_code.equals("Ethiopia")) {
                if (arrayListEthiopia.isNullOrEmpty()) {
                    for (value in ethiopia) {
                        val wallis_city = resources.getStringArray(R.array.Ethiopia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Ethiopia_code)[i]
                        i++
                        arrayListEthiopia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListEthiopia)
            } else if (selected_country == "500") {
                if (arrayListFakland.isNullOrEmpty()) {
                    for (value in falkland) {
                        val wallis_city = resources.getStringArray(R.array.FalklandIslands_city)[i]
                        val wallis_code = resources.getStringArray(R.array.FalklandIslands_code)[i]
                        i++
                        arrayListFakland.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListFakland)
            } else if (selected_country_code.equals("Faroe Islands")) {
                if (arrayListFaroe.isNullOrEmpty()) {
                    for (value in faroe) {
                        val wallis_city = resources.getStringArray(R.array.FaroeIslands_city)[i]
                        val wallis_code = resources.getStringArray(R.array.FaroeIslands_code)[i]
                        i++
                        arrayListFaroe.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListFaroe)
            } else if (selected_country_code.equals("Fiji")) {
                if (arrayListFiji.isNullOrEmpty()) {
                    for (value in fiji) {
                        val wallis_city = resources.getStringArray(R.array.Fiji_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Fiji_code)[i]
                        i++
                        arrayListFiji.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListFiji)
            } else if (selected_country_code.equals("Finland")) {
                if (arrayListFinland.isNullOrEmpty()) {
                    for (value in finland) {
                        val wallis_city = resources.getStringArray(R.array.Finland_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Finland_code)[i]
                        i++
                        arrayListFinland.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListFinland)
            } else if (selected_country_code.equals("French Guyana")) {
                if (arrayListFrenchGuyana.isNullOrEmpty()) {
                    for (value in frenchguyana) {
                        val wallis_city = resources.getStringArray(R.array.FrenchGuiana_city)[i]
                        val wallis_code = resources.getStringArray(R.array.FrenchGuiana_code)[i]
                        i++
                        arrayListFrenchGuyana.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListFrenchGuyana)
            } else if (selected_country_code.equals("French Polynesia")) {
                if (arrayListFrenchPolynesia.isNullOrEmpty()) {
                    for (value in frenchpolynesia) {
                        val wallis_city = resources.getStringArray(R.array.FrenchPolynesia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.FrenchPolynesia_code)[i]
                        i++
                        arrayListFrenchPolynesia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListFrenchPolynesia)
            } else if (selected_country_code.equals("Haiti")) {
                if (arrayListHaiti.isNullOrEmpty()) {
                    for (value in haiti) {
                        val wallis_city = resources.getStringArray(R.array.Haiti_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Haiti_code)[i]
                        i++
                        arrayListHaiti.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListHaiti)
            } else if (selected_country_code.equals("Honduras")) {
                if (arrayListHonduras.isNullOrEmpty()) {
                    for (value in honduras) {
                        val wallis_city = resources.getStringArray(R.array.Honduras_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Honduras_code)[i]
                        i++
                        arrayListHonduras.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListHonduras)
            } else if (selected_country_code.equals("Hong Kong")) {
                if (arrayListHongKong.isNullOrEmpty()) {
                    for (value in hongkong) {
                        val wallis_city = resources.getStringArray(R.array.HongKong_city)[i]
                        val wallis_code = resources.getStringArray(R.array.HongKong_code)[i]
                        i++
                        arrayListHongKong.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListHongKong)
            } else if (selected_country_code.equals("Hungary")) {
                if (arrayListHungary.isNullOrEmpty()) {
                    for (value in hungary) {
                        val wallis_city = resources.getStringArray(R.array.Hungary_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Hungary_code)[i]
                        i++
                        arrayListHungary.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListHungary)
            } else if (selected_country_code.equals("Iceland")) {
                if (arrayListIceland.isNullOrEmpty()) {
                    for (value in iceland) {
                        val wallis_city = resources.getStringArray(R.array.Iceland_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Iceland_code)[i]
                        i++
                        arrayListIceland.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListIceland)
            } else if (selected_country_code.equals("India")) {
                if (arrayListIndia.isNullOrEmpty()) {
                    for (value in india) {
                        val wallis_city = resources.getStringArray(R.array.India_city)[i]
                        val wallis_code = resources.getStringArray(R.array.India_code)[i]
                        i++
                        arrayListIndia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListIndia)
            } else if (selected_country == "98") {
                if (arrayListIran.isNullOrEmpty()) {
                    for (value in iran) {
                        val wallis_city = resources.getStringArray(R.array.Iran_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Iran_code)[i]
                        i++
                        arrayListIran.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListIran)
            } else if (selected_country_code.equals("Ireland")) {
                if (arrayListIreland.isNullOrEmpty()) {
                    for (value in ireland) {
                        val wallis_city = resources.getStringArray(R.array.Ireland_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Ireland_code)[i]
                        i++
                        arrayListIreland.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListIreland)
            } else if (selected_country_code.equals("Israel")) {
                if (arrayListIsrael.isNullOrEmpty()) {
                    for (value in israel) {
                        val wallis_city = resources.getStringArray(R.array.Israel_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Israel_code)[i]
                        i++
                        arrayListIsrael.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListIsrael)
            } else if (selected_country_code.equals("Italy")) {
                if (arrayListItaly.isNullOrEmpty()) {
                    for (value in italy) {
                        val wallis_city = resources.getStringArray(R.array.Italy_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Italy_code)[i]
                        i++
                        arrayListItaly.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListItaly)
            } else if (selected_country_code.equals("Jamaica")) {
                if (arrayListJamaica.isNullOrEmpty()) {
                    for (value in jamaica) {
                        val wallis_city = resources.getStringArray(R.array.Jamaica_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Jamaica_code)[i]
                        i++
                        arrayListJamaica.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListJamaica)
            } else if (selected_country_code.equals("Jordan")) {
                if (arrayListJordan.isNullOrEmpty()) {
                    for (value in jordan) {
                        val wallis_city = resources.getStringArray(R.array.Jordan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Jordan_code)[i]
                        i++
                        arrayListJordan.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListJordan)
            } else if (selected_country_code.equals("Kazakhstan")) {
                if (arrayListKazakhstan.isNullOrEmpty()) {
                    for (value in kazakhstan) {
                        val wallis_city = resources.getStringArray(R.array.Kazakhstan_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Kazakhstan_code)[i]
                        i++
                        arrayListKazakhstan.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListKazakhstan)
            } else if (selected_country_code.equals("Kenya")) {
                if (arrayListKenya.isNullOrEmpty()) {
                    for (value in kenya) {
                        val wallis_city = resources.getStringArray(R.array.Kenya_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Kenya_code)[i]
                        i++
                        arrayListKenya.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListKenya)
            } else if (selected_country_code.equals("Kiribati")) {
                if (arrayListKiribati.isNullOrEmpty()) {
                    for (value in kiribati) {
                        val wallis_city = resources.getStringArray(R.array.Kiribati_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Kiribati_code)[i]
                        i++
                        arrayListKiribati.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListKiribati)
            } else if (selected_country_code.equals("Kosovo")) {
                if (arrayListKosovo.isNullOrEmpty()) {
                    for (value in kosovo) {
                        val wallis_city = resources.getStringArray(R.array.Kosovo_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Kosovo_code)[i]
                        i++
                        arrayListKosovo.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListKosovo)
            } else if (selected_country_code.equals("Kuwait")) {
                if (arrayListKuwait.isNullOrEmpty()) {
                    for (value in kuwait) {
                        val wallis_city = resources.getStringArray(R.array.Kuwait_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Kuwait_code)[i]
                        i++
                        arrayListKuwait.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListKuwait)
            } else if (selected_country == "856") {
                if (arrayListLao.isNullOrEmpty()) {
                    for (value in lao) {
                        val wallis_city = resources.getStringArray(R.array.Laos_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Laos_code)[i]
                        i++
                        arrayListLao.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLao)
            } else if (selected_country_code.equals("Latvia")) {
                if (arrayListLatvia.isNullOrEmpty()) {
                    for (value in latvia) {
                        val wallis_city = resources.getStringArray(R.array.Latvia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Latvia_code)[i]
                        i++
                        arrayListLatvia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLatvia)
            } else if (selected_country_code.equals("Lebanon")) {
                if (arrayListLebanon.isNullOrEmpty()) {
                    for (value in lebanon) {
                        val wallis_city = resources.getStringArray(R.array.Lebanon_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Lebanon_code)[i]
                        i++
                        arrayListLebanon.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLebanon)
            } else if (selected_country_code.equals("Lesotho")) {
                if (arrayListLesotho.isNullOrEmpty()) {
                    for (value in lesotho) {
                        val wallis_city = resources.getStringArray(R.array.Lesotho_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Lesotho_code)[i]
                        i++
                        arrayListLesotho.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLesotho)
            } else if (selected_country_code.equals("Liberia")) {
                if (arrayListLiberia.isNullOrEmpty()) {
                    for (value in liberia) {
                        val wallis_city = resources.getStringArray(R.array.Liberia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Liberia_code)[i]
                        i++
                        arrayListLiberia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLiberia)
            } else if (selected_country_code.equals("Libya")) {
                if (arrayListLibya.isNullOrEmpty()) {
                    for (value in libya) {
                        val wallis_city = resources.getStringArray(R.array.Libya_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Libya_code)[i]
                        i++
                        arrayListLibya.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLibya)
            } else if (selected_country_code.equals("Liechtenstein")) {
                if (arrayListLiechtenstein.isNullOrEmpty()) {
                    for (value in liechtenstein) {
                        val wallis_city = resources.getStringArray(R.array.Liechtenstein_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Liechtenstein_code)[i]
                        i++
                        arrayListLiechtenstein.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLiechtenstein)
            } else if (selected_country_code.equals("Lithuania")) {
                if (arrayListLithuania.isNullOrEmpty()) {
                    for (value in lithuania) {
                        val wallis_city = resources.getStringArray(R.array.Lithuania_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Lithuania_code)[i]
                        i++
                        arrayListLithuania.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLithuania)
            } else if (selected_country_code.equals("Luxembourg")) {
                if (arrayListLuxembourg.isNullOrEmpty()) {
                    for (value in luxembourg) {
                        val wallis_city = resources.getStringArray(R.array.Luxembourg_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Luxembourg_code)[i]
                        i++
                        arrayListLuxembourg.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListLuxembourg)
            } else if (selected_country_code.equals("Oman")) {
                if (arrayListOman.isNullOrEmpty()) {
                    for (value in oman) {
                        val wallis_city = resources.getStringArray(R.array.Oman_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Oman_code)[i]
                        i++
                        arrayListOman.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListOman)
            }else if (selected_country_code.equals("Palau")) {
                if (arrayListPalau.isNullOrEmpty()) {
                    for (value in palau) {
                        val wallis_city = resources.getStringArray(R.array.Palau_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Palau_code)[i]
                        i++
                        arrayListPalau.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPalau)
            }else if (selected_country_code.equals("Palestine")) {
                if (arrayListPalestine.isNullOrEmpty()) {
                    for (value in palestine) {
                        val wallis_city = resources.getStringArray(R.array.Palestine_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Palestine_code)[i]
                        i++
                        arrayListPalestine.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPalestine)
            }else if (selected_country_code.equals("Panama")) {
                if (arrayListPanama.isNullOrEmpty()) {
                    for (value in panama) {
                        val wallis_city = resources.getStringArray(R.array.Panama_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Panama_code)[i]
                        i++
                        arrayListPanama.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPanama)
            }else if (selected_country_code.equals("Papua New Guinea")) {
                if (arrayListPapua.isNullOrEmpty()) {
                    for (value in papua) {
                        val wallis_city = resources.getStringArray(R.array.PapuaNewGuinea_city)[i]
                        val wallis_code = resources.getStringArray(R.array.PapuaNewGuinea_code)[i]
                        i++
                        arrayListPapua.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPapua)
            }else if (selected_country_code.equals("Peru")) {
                if (arrayListPeru.isNullOrEmpty()) {
                    for (value in peru) {
                        val wallis_city = resources.getStringArray(R.array.Peru_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Peru_code)[i]
                        i++
                        arrayListPeru.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPeru)
            }else if (selected_country_code.equals("Poland")) {
                if (arrayListPoland.isNullOrEmpty()) {
                    for (value in poland) {
                        val wallis_city = resources.getStringArray(R.array.Poland_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Poland_code)[i]
                        i++
                        arrayListPoland.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPoland)
            }else if (selected_country_code.equals("Puerto Rico")) {
                if (arrayListPuertoRico.isNullOrEmpty()) {
                    for (value in puertoRico) {
                        val wallis_city = resources.getStringArray(R.array.PuertoRico_city)[i]
                        val wallis_code = resources.getStringArray(R.array.PuertoRico_code)[i]
                        i++
                        arrayListPuertoRico.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListPuertoRico)
            }else if (selected_country_code.equals("Qatar")) {
                if (arrayListQatar.isNullOrEmpty()) {
                    for (value in qatar) {
                        val wallis_city = resources.getStringArray(R.array.Qatar_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Qatar_code)[i]
                        i++
                        arrayListQatar.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListQatar)
            }else if (selected_country=="262") {
                if (arrayListReunion.isNullOrEmpty()) {
                    for (value in reunion) {
                        val wallis_city = resources.getStringArray(R.array.Reunion_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Reunion_code)[i]
                        i++
                        arrayListReunion.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListReunion)
            }else if (selected_country_code.equals("Romania")) {
                if (arrayListRomania.isNullOrEmpty()) {
                    for (value in romania) {
                        val wallis_city = resources.getStringArray(R.array.Romania_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Romania_code)[i]
                        i++
                        arrayListRomania.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListRomania)
            }else if (selected_country_code.equals("Rwanda")) {
                if (arrayListRwanda.isNullOrEmpty()) {
                    for (value in rwanda) {
                        val wallis_city = resources.getStringArray(R.array.Rwanda_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Rwanda_code)[i]
                        i++
                        arrayListRwanda.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListRwanda)
            }else if (selected_country=="290") {
                if (arrayListSaintHelena.isNullOrEmpty()) {
                    for (value in saintlenena) {
                        val wallis_city = resources.getStringArray(R.array.SaintHelena_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SaintHelena_code)[i]
                        i++
                        arrayListSaintHelena.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSaintHelena)
            }else if (selected_country_code.equals("Saint Kitts and Nevis")) {
                if (arrayListSaintKittsAndNevis.isNullOrEmpty()) {
                    for (value in saintkittsandnevis) {
                        val wallis_city = resources.getStringArray(R.array.SaintKittsandNevis_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SaintKittsandNevis_code)[i]
                        i++
                        arrayListSaintKittsAndNevis.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSaintKittsAndNevis)
            }else if (selected_country_code.equals("Saint Lucia")) {
                if (arrayListSaintLucia.isNullOrEmpty()) {
                    for (value in saintlucia) {
                        val wallis_city = resources.getStringArray(R.array.SaintLucia_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SaintLucia_code)[i]
                        i++
                        arrayListSaintLucia.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSaintLucia)
            }else if (selected_country_code.equals("Saint Martin")) {
                if (arrayListSaintMartin.isNullOrEmpty()) {
                    for (value in saintmartin) {
                        val wallis_city = resources.getStringArray(R.array.SaintMartin_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SaintMartin_code)[i]
                        i++
                        arrayListSaintMartin.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSaintMartin)
            }/*
            else if (selected_country_code.equals("Saint Pierre And Miquelon")) {
                if (arrayListSaintPierre.isNullOrEmpty()) {
                    for (value in saintpierre) {
                        val wallis_city = resources.getStringArray(R.array.SaintPierraAndMiquelon_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SaintPierraAndMiquelon_code)[i]
                        i++
                        arrayListSaintPierre.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSaintPierre)
            }else if (selected_country_code.equals("Saint Vincent & The Grenadines")) {
                if (arrayListSaintVincent.isNullOrEmpty()) {
                    for (value in saintvincent) {
                        val wallis_city = resources.getStringArray(R.array.SaintVincentandtheGrenadines_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SaintVincentandtheGrenadines_code)[i]
                        i++
                        arrayListSaintVincent.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSaintVincent)
            }else if (selected_country_code.equals("Samoa")) {
                if (arrayListSamoa.isNullOrEmpty()) {
                    for (value in samoa) {
                        val wallis_city = resources.getStringArray(R.array.Samoa_city)[i]
                        val wallis_code = resources.getStringArray(R.array.Samoa_code)[i]
                        i++
                        arrayListSamoa.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSamoa)
            }else if (selected_country_code.equals("San Marino")) {
                if (arrayListSanMarino.isNullOrEmpty()) {
                    for (value in sanmarino) {
                        val wallis_city = resources.getStringArray(R.array.SanMarino_city)[i]
                        val wallis_code = resources.getStringArray(R.array.SanMarino_code)[i]
                        i++
                        arrayListSanMarino.add(CustomAreaCodesItem(wallis_city, wallis_code))
                    }
                }
                callAdapter(arrayListSanMarino)
            }*/
            else {
                Toast.makeText(this, "Nothing Found $selected_country", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun callAdapter(data: ArrayList<CustomAreaCodesItem>) {
        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView!!.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(applicationContext)
        adapter = CustomAreaCodesAdapter(data)
        mRecyclerView!!.setLayoutManager(mLayoutManager)
        mRecyclerView!!.setAdapter(adapter)
    }
}