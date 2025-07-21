using HotChocolate.Fusion;

var builder = WebApplication.CreateBuilder(args);

builder.WebHost.UseUrls("http://localhost:5000");

builder.Services.AddHttpClient("fusion");

builder.Services
    .AddFusionGatewayServer()
    .ConfigureFromFile("fusion/gateway.fgp");

var app = builder.Build();
app.MapGraphQL();
app.Run();