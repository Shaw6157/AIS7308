using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace AppMemoDemo
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();


            var webClient = new System.Net.WebClient();
            string result = webClient.DownloadString("http://shawyuais.co.nf/memo/phpGetMemos.php");
            MemoModel[] memoarray = JsonConvert.DeserializeObject<MemoModel[]>(result);
            

            //var memo = JsonConvert.DeserializeObject<MemoModel>(memoarray[0]);
            //DisplayAlert("txt", "memo :  " + memo.memoType + "      || string:" + result, null);
            DisplayAlert("txt", "memo :  " + memoarray[0].memoType + "      || string:" + result, null);


            //var strsingle_json = "{\"memoID\":\"1\",\"memoInfo\":\"qwe\",\"memoType\":\"q\",\"memoDate\":\"14112018\"}";
            //var mem2o = JsonConvert.DeserializeObject<MemoModel>(strsingle_json);
            //DisplayAlert("txt", "memo :  " + mem2o.memoType + "      || string:" + result, "cancan");
        }
    }
}
