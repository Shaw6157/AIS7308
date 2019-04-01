using System;
using System.Net.Http;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

[assembly: XamlCompilation (XamlCompilationOptions.Compile)]
namespace DBtest
{
	public partial class App : Application
	{
		public App ()
		{
			InitializeComponent();

			MainPage = new MainPage();
		}

		protected override void OnStart ()
		{
            // Handle when your app starts

            //var user = User.Text;
            //var pass = Pass.Text;
            try
            {

                //var postData = new List<KeyValuePair<string, string>>();
                //postData.Add(new KeyValuePair<string, string>("username", user));
                //postData.Add(new KeyValuePair<string, string>("password", pass));

                //var content = new FormUrlEncodedContent(postData);

                //HttpClient client = new HttpClient();

                //client.BaseAddress = new Uri("http://shawyuais.co.nf");

                //var response = await client.PostAsync("http://shawyuais.co.nf/memo/phpSaveMemo.php", content);
                //result = response.Content.ReadAsStringAsync().Result;

                var uri = "http://shawyuais.co.nf/memo/phpSaveMemo.php";

                HttpClient client = new HttpClient();
                var response = await client.GetAsync(uri);

            }
            catch (Exception ex)
            {
                //await DisplayAlert("Error", ex.ToString(), "Ok");
                return;
            }
        }

		protected override void OnSleep ()
		{
			// Handle when your app sleeps
		}

		protected override void OnResume ()
		{
			// Handle when your app resumes
		}
	}
}
