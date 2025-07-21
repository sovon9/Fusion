var builder = WebApplication.CreateBuilder(args);
builder.WebHost.UseUrls("http://localhost:5001");
builder.Services.AddGraphQLServer().AddQueryType<Query>();

var app = builder.Build();
app.MapGraphQL();
app.Run();
